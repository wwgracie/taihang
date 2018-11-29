package com.hengshi.test.models;

/**
 * @author wgy on 2018/11/29
 */
public class Login extends Model{
    private String email;
    private String password;
    private Object uuid;

    public Login() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Login email(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Login password(String password) {
        this.password = password;
        return this;
    }

    public Object getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Login uuid(Object uuid) {
        this.uuid = uuid;
        return this;
    }


}
