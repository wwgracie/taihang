package com.hengshi.test.models;

/**
 * @author wgy on 2018/11/30
 */
public class Timebar extends Model {
    private boolean show;
    private boolean autoPlay;
    private String field;
    private String current;
    private String select;
    private Object[] dateRange;
    private Object[] dateRangeForFilter;
    private String dateExp;

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }

    public Timebar show(boolean show) {
        this.show = show;
        return this;
    }

    public boolean isAutoPlay() {
        return autoPlay;
    }

    public void setAutoPlay(boolean autoPlay) {
        this.autoPlay = autoPlay;
    }

    public Timebar autoPlay(boolean autoPlay) {
        this.autoPlay = autoPlay;
        return this;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Timebar field(String field) {
        this.field = field;
        return this;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public Timebar current(String current) {
        this.current = current;
        return this;
    }

    public String getSelect() {
        return select;
    }

    public void setSelect(String select) {
        this.select = select;
    }

    public Timebar select(String select) {
        this.select = select;
        return this;
    }


    public Object[] getDateRange() {
        return dateRange;
    }

    public void setDateRange(Object[] dateRange) {
        this.dateRange = dateRange;
    }

    public Timebar dateRange(Object[] dateRange) {
        this.dateRange = dateRange;
        return this;
    }

    public Object[] getDateRangeForFilter() {
        return dateRangeForFilter;
    }

    public void setDateRangeForFilter(Object[] dateRangeForFilter) {
        this.dateRangeForFilter = dateRangeForFilter;
    }

    public Timebar dateRangeForFilter(Object[] dateRangeForFilter) {
        this.dateRangeForFilter = dateRangeForFilter;
        return this;
    }

    public String getDateExp() {
        return dateExp;
    }

    public void setDateExp(String dateExp) {
        this.dateExp = dateExp;
    }

    public Timebar dateExp(String dateExp) {
        this.dateExp = dateExp;
        return this;
    }

    public static Timebar baseTimebar() {
        return new Timebar().show(true).autoPlay(false).field("").current("dateExp").select("dateExp").dateExp("All");
    }

}
