package com.hengshi.utils;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.*;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class HttpClientSession {
    private static final Logger log = LogManager.getLogger(HttpClientSession.class);
    private CloseableHttpClient httpClient = null;
    private HttpClientContext context = null;
    private CookieStore cookieStore = null;
    private RequestConfig requestConfig = null;
    private String csrftoken = null;


    {
        init();
    }

    private void init() {
        context = HttpClientContext.create();
        cookieStore = new BasicCookieStore();
        // 配置超时时间（连接服务端超时1秒，请求数据返回超时2秒）
        requestConfig = RequestConfig.custom().setConnectTimeout(240000).setSocketTimeout(240000)
                .setConnectionRequestTimeout(120000).build();
        // 设置默认跳转以及存储cookie
        httpClient = HttpClientBuilder.create()
                .setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy())
                .setRedirectStrategy(new DefaultRedirectStrategy()).setDefaultRequestConfig(requestConfig)
                .setDefaultCookieStore(cookieStore).build();
    }

    /**
     * http get
     *
     * @param url
     * @return response
     * @throws ClientProtocolException
     * @throws IOException
     */
    public String get(String url) throws ClientProtocolException, IOException {
        HttpGet httpget = new HttpGet(url);
        CloseableHttpResponse response = httpClient.execute(httpget, context);
        String responseContent = null;
        try {
            cookieStore = context.getCookieStore();
            List<Cookie> cookies = cookieStore.getCookies();
            for (Cookie cookie : cookies) {
                log.debug("key:" + cookie.getName() + "  value:" + cookie.getValue());

            }
            responseContent = EntityUtils.toString(response.getEntity());
        } finally {
            response.close();
        }
        return responseContent;
    }

    /**
     * login
     *
     * @param url
     * @param payload
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     */
    public String login(String url, String payload)
            throws ClientProtocolException, IOException {
        HttpPost httpPost = new HttpPost(url);
        StringEntity entity = new StringEntity(payload);
        log.info("login payload: " + payload);
        httpPost.addHeader("Content-Type", "application/json");
        httpPost.setEntity(entity);
        CloseableHttpResponse response = httpClient.execute(httpPost, context);
        String responseStr = EntityUtils.toString(response.getEntity());
        log.info("login response: " + responseStr);
        try {
            cookieStore = context.getCookieStore();
            List<Cookie> cookies = cookieStore.getCookies();
            for (Cookie cookie : cookies) {
                log.debug("key:" + cookie.getName() + "  value:" + cookie.getValue());
                if (cookie.getName().equals("csrf")) {
                    csrftoken = cookie.getValue();
                }
            }
            String setCookie = null;
            for (Header header : response.getHeaders("Set-Cookie")) {
                if (header.getValue().contains("sid=")) {
                    setCookie = header.getValue();
                    break;
                }
            }

            String sessionid = setCookie.substring("sid=".length(), setCookie.indexOf(";"));
            // 新建一个Cookie
            BasicClientCookie cookie1 = new BasicClientCookie("sid", sessionid);
            cookie1.setDomain(Constants.httpDomain);

            cookie1.setPath("/");
            cookieStore.addCookie(cookie1);
        } finally {
            response.close();
        }
        return responseStr;
    }

    /**
     * http post
     *
     * @param url
     * @param payload
     * @return response
     * @throws ClientProtocolException
     * @throws IOException
     */
    public String post(String url, String payload)
            throws ClientProtocolException, IOException {
        HttpPost httpPost = new HttpPost(url);
        StringEntity entity = new StringEntity(payload, Constants.coding);
        httpPost.addHeader("Content-Type", "application/json");
        httpPost.setEntity(entity);
        httpPost.setHeader("x-csrf-token", csrftoken);
        CloseableHttpResponse response = httpClient.execute(httpPost, context);
        String responseStr = EntityUtils.toString(response.getEntity());
        response.close();
        return responseStr;
    }

    /**
     * http post
     *
     * @param url
     * @param payload
     * @param limit
     * @return response
     * @throws ClientProtocolException
     * @throws IOException
     */
    public String post(String url, String limit, String payload)
            throws ClientProtocolException, IOException {
        List<NameValuePair> postParameters = new ArrayList<>();
        postParameters.add(new BasicNameValuePair("offset", "0"));
        postParameters.add(new BasicNameValuePair("limit", limit));
        try {
            URIBuilder uriBuilder = new URIBuilder(url);
            uriBuilder.addParameters(postParameters);
            HttpPost httpPost = new HttpPost(uriBuilder.build());

            StringEntity entity = new StringEntity(payload, Constants.coding);
            httpPost.addHeader("Content-Type", "application/json");
            httpPost.setEntity(entity);
            httpPost.setHeader("x-csrf-token", csrftoken);
            CloseableHttpResponse response = httpClient.execute(httpPost, context);
            String responseStr = EntityUtils.toString(response.getEntity());
            response.close();
            return responseStr;
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * http post
     *
     * @param url
     * @param fileName
     * @return response
     * @throws ClientProtocolException
     * @throws IOException
     */
    public String upload(String url, String fileName)
            throws ClientProtocolException, IOException {
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader("Content-Type", "multipart/form-data; boundary=12106075217940237331486476651");
        File file = new File(fileName);

        HttpEntity httpEntity = MultipartEntityBuilder.create()
                .setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
                .setBoundary("12106075217940237331486476651")
                .addBinaryBody("file", file)
                .build();

        httpPost.setEntity(httpEntity);
        httpPost.setHeader("x-csrf-token", csrftoken);
        CloseableHttpResponse response = httpClient.execute(httpPost, context);
        String responseStr = EntityUtils.toString(response.getEntity());
        response.close();
        return responseStr;
    }

    /**
     * http put
     *
     * @param url
     * @param payload
     * @return response
     * @throws ClientProtocolException
     * @throws IOException
     */
    public String put(String url, String payload)
            throws ClientProtocolException, IOException {
        HttpPut httpPut = new HttpPut(url);
        StringEntity entity = new StringEntity(payload, Constants.coding);
        httpPut.addHeader("Content-Type", "application/json");
        httpPut.setEntity(entity);
        httpPut.setHeader("x-csrf-token", csrftoken);
        CloseableHttpResponse response = httpClient.execute(httpPut, context);
        String responseStr = EntityUtils.toString(response.getEntity());
        response.close();
        return responseStr;
    }

    public void closeSession() throws IOException {
        if (httpClient != null) httpClient.close();
    }


}
