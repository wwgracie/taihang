package com.hengshi.test.models;

/**
 * @author wgy on 2018/11/29
 */
public class Dashboard extends Model {
    private String title;
    private Object options;

    public Dashboard(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Dashboard title(String title) {
        this.title = title;
        return this;
    }


    public Object getOptions() {
        return options;
    }

    public void setOptions(Object options) {
        this.options = options;
    }

    public Dashboard options(Object options) {
        this.options = options;
        return this;
    }


}
