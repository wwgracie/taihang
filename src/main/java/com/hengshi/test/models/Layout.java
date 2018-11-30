package com.hengshi.test.models;

/**
 * @author wgy on 2018/11/30
 */
public class Layout {
    private Object i;
    private Object x;
    private Object y;
    private Object w;
    private Object h;

    public Layout() {

    }

    public Layout(Object i, Object x, Object y, Object w, Object h) {
        this.i = i;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public Object getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public Layout i(int i ) {
        this.i = i;
        return this;
    }

    public Object getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public Layout x(int x ) {
        this.x = x;
        return this;
    }

    public Object getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Layout y(int y ) {
        this.y = y;
        return this;
    }


    public Object getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public Layout w(int w ) {
        this.w = w;
        return this;
    }

    public Object getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public Layout h(int h ) {
        this.h = h;
        return this;
    }
}
