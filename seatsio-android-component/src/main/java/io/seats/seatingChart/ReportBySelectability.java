package io.seats.seatingChart;

import java.util.Map;

public class ReportBySelectability {

    public class ReportBySelectabilityContents {

        public int count;
        public Map<String, Integer> byCategoryKey;
        public Map<String, Integer> byCategoryLabel;
    }

    public ReportBySelectabilityContents selectable;
    public ReportBySelectabilityContents not_selectable;
}
