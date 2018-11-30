package com.hengshi.test.models;

/**
 * @author wgy on 2018/11/30
 */
public class ResponseObject extends Model {
    private int code;
    private String body;

    public ResponseObject() {

    }

    public ResponseObject(int code, String body) {
        this.code = code;
        this.body = body;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ResponseObject code(int code) {
        this.code = code;
        return this;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public ResponseObject body(String body) {
        this.body = body;
        return this;
    }

}
