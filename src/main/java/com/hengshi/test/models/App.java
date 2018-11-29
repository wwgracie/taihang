package com.hengshi.test.models;

/**
 * @author wgy on 2018/11/29
 */
public class App extends Model {
    private String title;
    private Object options;

    public App(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public App title(String name) {
        this.title = name;
        return this;
    }


    public Object getOptions() {
        return options;
    }

    public void setOptions(Object options) {
        this.options = options;
    }

    public App options(Object options) {
        this.options = options;
        return this;
    }


}
