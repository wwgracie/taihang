package com.hengshi.test.models;

/**
 * @author wgy on 2018/11/30
 */
public class DashboardOptions {

    private Object layouts;

    public DashboardOptions() {

    }

    public DashboardOptions layouts(Object layouts) {
        this.layouts = layouts;
        return this;
    }

    public Object getLayouts() {
        return layouts;
    }

    public void setLayouts(Object layouts) {
        this.layouts = layouts;
    }

}
