package com.hengshi.test.models;

/**
 * @author wgy on 2018/11/29
 */
public class Options {

    private Object dashboardsOrder;
    private Object charts;
    private Object filters;
    private Object layouts;
    private String layoutsVersion;

    public Object getDashboardsOrder() {
        return dashboardsOrder;
    }

    public void setDashboardsOrder(Object dashboardsOrder) {
        this.dashboardsOrder = dashboardsOrder;
    }


    public Object getCharts() {
        return charts;
    }

    public void setCharts(Object charts) {
        this.charts = charts;
    }

    public Object getFilters() {
        return filters;
    }

    public void setFilters(Object filters) {
        this.filters = filters;
    }

    public Object getLayouts() {
        return layouts;
    }

    public void setLayouts(Object layouts) {
        this.layouts = layouts;
    }

    public String getLayoutsVersion() {
        return layoutsVersion;
    }

    public void setLayoutsVersion(String layoutsVersion) {
        this.layoutsVersion = layoutsVersion;
    }
}
