package io.seats;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

public class Caller {

    private final SeatsioWebView seatsioWebView;
    private Map<String, AsyncRequest> asyncRequests = new HashMap<>();

    Caller(SeatsioWebView seatsioWebView) {
        this.seatsioWebView = seatsioWebView;
    }

    public void call(String code) {
        seatsioWebView.post(() -> seatsioWebView.evaluateJavascript(code, null));
    }

    public void call(String code, Consumer<String> callback) {
        seatsioWebView.post(() -> seatsioWebView.evaluateJavascript(code, callback::accept));
    }

    public void callAsync(String code, Consumer<String> successCallback) {
        String requestId = UUID.randomUUID().toString();
        asyncRequests.put(requestId, new AsyncRequest(successCallback));
        String js = code + ".then(asyncCallSuccess('" + requestId + "'))";
        seatsioWebView.post(() -> seatsioWebView.evaluateJavascript(js, null));
    }

    public void callAsync(String code, Consumer<String> successCallback, Runnable errorCallback) {
        String requestId = UUID.randomUUID().toString();
        asyncRequests.put(requestId, new AsyncRequest(successCallback, errorCallback));
        String js = code + ".then(asyncCallSuccess('" + requestId + "'), asyncCallError('" + requestId + "'))";
        seatsioWebView.post(() -> seatsioWebView.evaluateJavascript(js, null));
    }

    private static String escapeSingleQuotes(String s) {
        return s.replaceAll("'", "\\\\'");
    }

    public void onSuccess(String result, String requestId) {
        AsyncRequest asyncRequest = asyncRequests.remove(requestId);
        asyncRequest.successCallback.accept(result);
    }

    public void onError(String requestId) {
        AsyncRequest asyncRequest = asyncRequests.remove(requestId);
        asyncRequest.errorCallback.run();
    }
}
