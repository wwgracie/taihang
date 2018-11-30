package com.hengshi.test.base;

import com.hengshi.test.config.Configuration;
import com.hengshi.test.models.App;
import com.hengshi.test.models.Dashboard;
import com.hengshi.test.models.ResponseObject;
import com.hengshi.utils.Constants;
import com.hengshi.utils.HttpClientSession;
import com.jayway.jsonpath.JsonPath;
import org.apache.log4j.Logger;
import org.testng.Assert;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    // This is a base class for all test cases.
    protected static final Logger logger = Logger.getLogger(BaseTest.class);
    protected static Configuration config = new Configuration();

    public static int prepareApp(HttpClientSession httpcs, String appname) throws IOException {
        String url = config.getAppCreateUrl();
        String payload = new App(appname).toString();
        String response = httpcs.post(url, payload).getBody();
        int id = JsonPath.read(response, "$.data.id");
        return id;
    }

    public static int prepareDashboard(HttpClientSession httpcs, int appid, String dsbname) throws IOException {
        String url = config.getDashboardCreateUrl(appid);
        String payload = new Dashboard(dsbname).toString();
        String response = httpcs.post(url, payload).getBody();
        int id = JsonPath.read(response, "$.data.id");
        return id;
    }

    public static String uploadFile(HttpClientSession httpcs, String filePath) throws IOException {
        String response = httpcs.upload(config.getUploadFileUrl(), filePath);
        String fileid = JsonPath.read(response, "$..fileId");
        return fileid;

    }

    public static int createLocalFileDataset(HttpClientSession httpcs, int appid, String filepath, String payload) throws IOException {
        String fileid = uploadFile(httpcs, filepath);
        String url = config.getLocalFileDatasetCreateUrl(appid, fileid);
        String response = httpcs.post(url, payload).getBody();
        int id =  JsonPath.read(response, "$.data.id");
        return id;
    }

    public static void checkDatasetReady(HttpClientSession httpcs, int appid, int dsid) throws IOException, InterruptedException {
        String url = config.getDatasetUrl(appid, dsid);
        int status = 0;
        int i = 0;
        while(status != Constants.DATASETREADY && i < Constants.CHECKDSSTATUSCOUNTER) {
            logger.info("Wait dataset ready: " + i + " times");
            TimeUnit.SECONDS.sleep(i++);
            String response = httpcs.get(url).getBody();
            response = httpcs.get(url).getBody();
            status = JsonPath.read(response, "$.data.status");
        }
    }

    public void doTest(String testcase, HttpClientSession httpcs, String requestMethod, String url, String params, int expCode, String expBody, String jsonpath) {
        try {
            logger.info("--------------------  TestCase Started  --------------------");
            logger.info("Test case summary: " + testcase);
            logger.info(requestMethod + " " + url);
            if(params != null) {
                logger.info("Payload: " + params);
            }
            ResponseObject responseObject = new ResponseObject();
            if(requestMethod.equals(Constants.GET)) {
                responseObject = httpcs.get(url);
            }
            if(requestMethod.equals(Constants.POST)) {
                responseObject = httpcs.post(url, params);
            }
            if(requestMethod.equals(Constants.PUT)) {
                responseObject = httpcs.put(url, params);
            }
            if(requestMethod.equals(Constants.DELETE)) {
                responseObject = httpcs.delete(url);
            }
            String actualBody = "";
            if(jsonpath != null) {
                actualBody = JsonPath.read(responseObject.getBody(), jsonpath);
            }
            else {
                actualBody = null;
            }
            logger.info("Complete response: " + responseObject);
            ResponseObject actual = responseObject.body(actualBody);
            ResponseObject expected = new ResponseObject(expCode, expBody);
            logger.info("Actual:");
            logger.info("Code: " + actual.getCode());
            logger.info("Body: " + actualBody);
            logger.info("Expected:");
            logger.info("Code: " + expected.getCode());
            logger.info("Body: " + expBody);
            logger.info("--------------------  TestCase Finished  --------------------");
            System.out.println("\n");
            Assert.assertEquals(actual.toString(), expected.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doTest(String testcase, HttpClientSession httpcs, String requestMethod, String url, String params, int code) throws IOException {
        doTest(testcase, httpcs, requestMethod, url, params, code, null, null);
    }

    public void doPost(String testcase, HttpClientSession httpcs, String url, String params, int code) throws IOException {
        doTest(testcase, httpcs, Constants.POST, url, params, code, null, null);
    }

    public void doPost(String testcase, HttpClientSession httpcs, String url, String params, int code, String expected, String jsonPath) throws IOException {
        doTest(testcase, httpcs, Constants.POST, url, params, code, expected, jsonPath);
    }

    public void doPut(String testcase, HttpClientSession httpcs, String url, String params, int code) throws IOException {
        doTest(testcase, httpcs, Constants.PUT, url, params, code, null, null);
    }

    public void doPut(String testcase, HttpClientSession httpcs, String url, String params, int code, String expected, String jsonPath) throws IOException {
        doTest(testcase, httpcs, Constants.PUT, url, params, code, expected, jsonPath);
    }

    public void doGet(String testcase, HttpClientSession httpcs, String url, int code) throws IOException {
        doTest(testcase, httpcs, Constants.GET, url, null, code, null, null);
    }

    public void doGet(String testcase, HttpClientSession httpcs, String url, int code, String expected, String jsonPath) throws IOException {
        doTest(testcase, httpcs, Constants.GET, url, null, code, expected, jsonPath);
    }

}