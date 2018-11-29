package com.hengshi.test.models;

import com.hengshi.utils.JsonUtils;

public class Expr {
    private String kind;
    private String op;
    private Object[] args;

    public Expr kind(String kind) {
        this.kind = kind;
        return this;
    }

    public Expr op(String op) {
        this.op = op;
        return this;
    }

    public Expr args(Object[] args) {
        this.args = args;
        return this;
    }


    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    public String toString() {
        return JsonUtils.toString(this);
    }


}
