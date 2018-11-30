package com.hengshi.test.models;

/**
 * @author wgy on 2018/11/30
 */
public class ChartOptions extends Model {
    private String type;
    private Object[] axes;
    private Object[] where;
    private Object[] having;
    private Object[] sort;
    private Object timebar;
    private int limit;
    private Object autoRefresh;
    private Object tooltip;
    private Object[] padding;
    private Object scaleRange;
    private Object legend;
    private Object axis;
    private Object gridline;
    private Object brush;
    private Object[] colorSchema;

    public ChartOptions() {

    }

    public ChartOptions(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ChartOptions type(String type) {
        this.type = type;
        return this;
    }


    public Object[] getAxes() {
        return axes;
    }

    public void setAxes(Object[] axes) {
        this.axes = axes;
    }

    public ChartOptions axes(Object[] axes) {
        this.axes = axes;
        return this;
    }

    public Object[] getWhere() {
        return where;
    }

    public void setWhere(Object[] where) {
        this.where = where;
    }

    public ChartOptions where(Object[] where) {
        this.where = where;
        return this;
    }

    public Object[] getHaving() {
        return having;
    }

    public void setHaving(Object[] having) {
        this.having = having;
    }

    public ChartOptions having(Object[] having) {
        this.having = having;
        return this;
    }

    public Object[] getSort() {
        return sort;
    }

    public void setSort(Object[] sort) {
        this.sort = sort;
    }

    public ChartOptions sort(Object[] sort) {
        this.sort = sort;
        return this;
    }


    public Object getTimebar() {
        return timebar;
    }

    public void setTimebar(Object timebar) {
        this.timebar = timebar;
    }

    public ChartOptions timebar(Object timebar) {
        this.timebar = timebar;
        return this;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public ChartOptions limit(int limit) {
        this.limit = limit;
        return this;
    }

    public Object getAutoRefresh() {
        return autoRefresh;
    }

    public void setAutoRefresh(Object autoRefresh) {
        this.autoRefresh = autoRefresh;
    }

    public ChartOptions autoRefresh(Object autoRefresh) {
        this.autoRefresh = autoRefresh;
        return this;
    }

    public Object getTooltip() {
        return tooltip;
    }

    public void setTooltip(Object tooltip) {
        this.tooltip = tooltip;
    }

    public ChartOptions tooltip(Object tooltip) {
        this.tooltip = tooltip;
        return this;
    }

    public Object[] getPadding() {
        return padding;
    }

    public void setPadding(Object[] padding) {
        this.padding = padding;
    }

    public ChartOptions padding(Object... padding) {
        this.padding = padding;
        return this;
    }

    public Object getScaleRange() {
        return scaleRange;
    }

    public void setScaleRange(Object scaleRange) {
        this.scaleRange = scaleRange;
    }

    public ChartOptions scaleRange(Object scaleRange) {
        this.scaleRange = scaleRange;
        return this;
    }

    public Object getLegend() {
        return legend;
    }

    public void setLegend(Object legend) {
        this.legend = legend;
    }

    public ChartOptions legend(Object legend) {
        this.legend = legend;
        return this;
    }

    public Object getAxis() {
        return axis;
    }

    public void setAxis(Object axis) {
        this.axis = axis;
    }

    public ChartOptions axis(Object axis) {
        this.axis = axis;
        return this;
    }

    public Object getGridline() {
        return gridline;
    }

    public void setGridline(Object gridline) {
        this.gridline = gridline;
    }

    public ChartOptions gridline(Object gridline) {
        this.gridline = gridline;
        return this;
    }

    public Object getBrush() {
        return brush;
    }

    public void setBrush(Object brush) {
        this.brush = brush;
    }

    public ChartOptions brush(Object brush) {
        this.brush = brush;
        return this;
    }

    public Object[] getColorSchema() {
        return colorSchema;
    }

    public void setColorSchema(Object[] colorSchema) {
        this.colorSchema = colorSchema;
    }

    public ChartOptions colorSchema(Object... colorSchema) {
        this.colorSchema = colorSchema;
        return this;
    }
}
