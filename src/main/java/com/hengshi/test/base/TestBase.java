package com.hengshi.test.base;

import com.google.common.collect.ImmutableMap;
import com.hengshi.test.config.Configuration;
import com.hengshi.test.models.App;
import com.hengshi.test.models.Dashboard;
import com.hengshi.utils.HttpClientSession;
import com.jayway.jsonpath.JsonPath;

import java.io.IOException;

public class TestBase {
    // This is a base class for all test cases.
    public static Configuration config = new Configuration();

    public int prepareApp(HttpClientSession httpcs, String appname) throws IOException {
        String url = config.getAppCreateUrl();
        String payload = new App(appname).toString();
        String response = httpcs.post(url, payload);
        int id = JsonPath.read(response, "$.data.id");
        return id;
    }

    public int prepareDashboard(HttpClientSession httpcs, int appid, String dsbname) throws IOException {
        String url = config.getDashboardCreateUrl(appid);
        String payload = new Dashboard(dsbname).toString();
        String response = httpcs.post(url, payload);
        int id = JsonPath.read(response, "$.data.id");
        return id;
    }


}