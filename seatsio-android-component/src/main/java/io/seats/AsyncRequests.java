package io.seats;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

public class AsyncRequests {

    private final SeatingChart seatingChart;
    private Map<String, AsyncRequest> asyncRequests = new HashMap<>();

    AsyncRequests(SeatingChart seatingChart) {
        this.seatingChart = seatingChart;
    }

    void doRequest(String function, Consumer<String> successCallback) {
        String requestId = UUID.randomUUID().toString();
        asyncRequests.put(requestId, new AsyncRequest(successCallback));
        String js = "chart." + function + "(" +
                "asyncCallSuccess('" + requestId + "')" +
                ")";
        seatingChart.evaluateJavascript(js, null);
    }

    void doRequest(String function, String param, Consumer<String> successCallback, Runnable errorCallback) {
        String requestId = UUID.randomUUID().toString();
        asyncRequests.put(requestId, new AsyncRequest(successCallback, errorCallback));
        String js = "chart." + function + "(" +
                "'" + escapeSingleQuotes(param) + "'" +
                ", asyncCallSuccess('" + requestId + "')" +
                ", asyncCallError('" + requestId + "')" +
                ")";
        seatingChart.evaluateJavascript(js, null);
    }

    void doRequest(String function, Consumer<String> successCallback, Runnable errorCallback) {
        String requestId = UUID.randomUUID().toString();
        asyncRequests.put(requestId, new AsyncRequest(successCallback, errorCallback));
        String js = "chart." + function + "(" +
                "asyncCallSuccess('" + requestId + "')" +
                ", asyncCallError('" + requestId + "')" +
                ")";
        seatingChart.evaluateJavascript(js, null);
    }

    private static String escapeSingleQuotes(String s) {
        return s.replaceAll("'", "\\\\'");
    }

    void onSuccess(String result, String requestId) {
        AsyncRequest asyncRequest = asyncRequests.remove(requestId);
        asyncRequest.successCallback.accept(result);
    }

    void onError(String requestId) {
        AsyncRequest asyncRequest = asyncRequests.remove(requestId);
        asyncRequest.errorCallback.run();
    }
}
