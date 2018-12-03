package com.hengshi.test.models;

import com.google.common.collect.ImmutableMap;

/**
 * @author wgy on 2018/11/29
 */
public class Chart extends Model {
    private String title;
    private int datasetId;
    private Object options;
    private Object dashboardOptions;


    public Chart(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Chart title(String title) {
        this.title = title;
        return this;
    }

    public int getDatasetId() {
        return datasetId;
    }

    public void setDatasetId(int datasetId) {
        this.datasetId = datasetId;
    }

    public Chart datasetId(int datasetId) {
        this.datasetId = datasetId;
        return this;
    }

    public Object getOptions() {
        return options;
    }

    public void setOptions(Object options) {
        this.options = options;
    }

    public Chart options(Object options) {
        this.options = options;
        return this;
    }

    public Object getDashboardOptions() {
        return dashboardOptions;
    }

    public void setDashboardOptions(Object dashboardOptions) {
        this.dashboardOptions = dashboardOptions;
    }

    public Chart dashboardOptions(Object dashboardOptions) {
        this.dashboardOptions = dashboardOptions;
        return this;
    }

    public static Chart baseChart(String title, int datasetId) {
        return new Chart(title).datasetId(datasetId)
                .dashboardOptions(ImmutableMap.of("layouts", ImmutableMap.of("null", new Layout("null",0,0,24,12))))
                .options(new ChartOptions().type("Bar").timebar(new Timebar().baseTimebar()).limit(1000)
                        .autoRefresh(ImmutableMap.of("start", false, "time", 30))
                        .tooltip(ImmutableMap.of("show", true))
                        .padding(0,10,0,0).legend(ImmutableMap.of("show", true, "position", "right"))
                        .axis(ImmutableMap.of("labelShow", true, "centerLabelShow", true,"showX", true,"showY", true))
                        .gridline(ImmutableMap.of("showX",true,"x",3,"showY",true,"y",3))
                        .brush(ImmutableMap.of("show", false))
                        .colorSchema("#4CDFE8","#00C5EE","#00AAEF","#018FE8","#3B78DE","#3C58EA","#533EE5","#6838E4","#8E2DF6","#C948F7"));

    }

}
