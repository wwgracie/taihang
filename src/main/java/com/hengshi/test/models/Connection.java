package com.hengshi.test.models;

/**
 * @author wgy on 2018/11/28
 */
public class Connection extends Model {
    private String title;
    private String type;
    private String host;
    private int port;
    private String username;
    private String password;
    private String database;
    private String encoding;
    private String category;

    public Connection(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Connection title(String title) {
        this.title = title;
        return this;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Connection type(String type) {
        this.type = type;
        return this;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Connection host(String host) {
        this.host = host;
        return this;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public Connection port(int port) {
        this.port = port;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Connection username(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Connection password(String password) {
        this.password = password;
        return this;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public Connection database(String database) {
        this.database = database;
        return this;
    }


    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public Connection encoding(String encoding) {
        this.encoding = encoding;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Connection category(String category) {
        this.category = category;
        return this;
    }
}
