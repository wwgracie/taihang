package com.hengshi.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hengshi.test.config.Configuration;
import com.hengshi.test.models.Login;

import java.io.IOException;

/**
 * @author wgy on 2018/11/29
 */
public class LoginUtils {
    public static Configuration config = new Configuration();

    public static JSONObject getRSA(HttpClientSession httpClientSession) throws IOException {
        String urlStr = config.getBaseUrl() + "/api/rsa";
        String responseStr = httpClientSession.post(urlStr,"");
        JSONObject responseJson = (JSONObject) JSON.parse(responseStr);
        return responseJson.getJSONObject("data");
    }

    public static String getEncrypt(String password, String publicKey) {
        String encpassword = "";
        try {
            encpassword = RSAEncrypt.encrypt(password, publicKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encpassword;
    }


    public static void login(HttpClientSession httpClientSession, String username, String password) throws IOException {
        httpClientSession.get(config.getLoginInfoUrl());
        JSONObject loginInfo = getRSA(httpClientSession);
        String encpassword = getEncrypt(password,loginInfo.getString("publicKey"));
        String loginBody = new Login().email(username).password(encpassword).uuid(loginInfo.get("uuid")).toString();
        httpClientSession.login(config.getLoginUrl(),loginBody);
    }


    public static void login(HttpClientSession httpClientSession) throws IOException {
        String username = config.getUsername();
        String password = config.getPassword();
        login(httpClientSession, username, password);
    }


    public static void close(HttpClientSession httpClientSession) throws IOException {
        httpClientSession.closeSession();
    }


}
