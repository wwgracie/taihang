package com.hengshi.test.config;

import com.hengshi.utils.PropertiesUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Properties;

/**
 * @author wgy on 2018/11/28
 */
public class Configuration {
    private static final Logger log = LogManager.getLogger(Configuration.class);
    protected String configPath = "config/test.properties";
    protected String env;
    protected Properties properties;

    public Configuration() {
        initConfig(configPath);
    }

    protected void initConfig(String configPath) {
        if (configPath != null) {
            this.properties = new PropertiesUtils().load(configPath);
            this.env = properties.getProperty("env", "");
        }
    }

    public Properties getProperties() {
        return this.properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setProperties(String configPath) {
        this.properties = new PropertiesUtils().load(configPath);
    }

    public Object getProperty(String key) {
        return properties.get(key);
    }

    public String getBaseUrl() {
        return properties.getProperty(env + ".url");
    }

    public String getUsername() {
        return properties.getProperty(env + ".username");
    }

    public String getPassword() {
        return properties.getProperty(env + ".password");
    }

    public String getLoginUrl() {
        return getBaseUrl() + "/api/auth/login";
    }

    public String getLoginInfoUrl() {
        return getBaseUrl() + "/api/auth/login-info";
    }

    public String getConnectionCreateUrl() {
        return getBaseUrl() + "/api/connections";
    }

    public String getAppCreateUrl() {
        return getBaseUrl() + "/api/apps";
    }

    public String getDatasetUrl(int appid, int dsid) {
        return getBaseUrl() + "/api/apps/" + appid + "/datasets/" + dsid;
    }


    public String getDomain() {
        if(getProperty("localdomain").equals("yes")){
            return "localhost";
        }
        else {
            return getBaseUrl().split("/")[2];
        }
    }

    public String getDashboardCreateUrl(int appid) {
        return getBaseUrl() + "/api/apps/" + appid + "/dashboards";
    }

    public String getUploadFileUrl() { return getBaseUrl() + "/api/files"; }

    public String getLocalFileDatasetCreateUrl(int appid, String fileid) {
        return getBaseUrl() + "/api/files/" + fileid + "/sheets/0/apps/" + "appid" + "/save"; }

}
