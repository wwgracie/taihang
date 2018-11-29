package com.hengshi.test.base;
import com.google.common.collect.ImmutableMap;
import com.mashape.unirest.http.Headers;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import org.json.*;

import java.math.BigDecimal;

public class JsonTest {
    public static void main(String[] args) throws Exception {

//        JSONArray myObject = new JSONArray("[[\"2016-01-01\",5,null,null,null],[\"2017-01-01\",105,null,null,null]]");
//
//
////        double d =  myObject.getJSONArray(0).getDouble(4);
//
//
//        //System.out.println(myFloatValue);
////        System.out.println(d);
//
        String response = "{\"data\":{\"data\":[[\"2015-12-28\",-2.0000000000000000,null,null,null],[\"2016-01-04\",-7.3333333333333333,-2.0000000000000000,-5.3333333333333333,null],[\"2016-02-01\",4.0000000000000000,null,null,null],[\"2016-02-08\",9.0000000000000000,4.0000000000000000,5.0000000000000000,1.2500000000000000],[\"2016-12-26\",1.00000000000000000000,null,null,null],[\"2017-01-02\",5.0000000000000000,1.00000000000000000000,4.00000000000000000000,4.00000000000000000000],[\"2017-01-09\",9.5000000000000000,5.0000000000000000,4.5000000000000000,0.90000000000000000000],[\"2017-01-30\",3.0000000000000000,null,null,null],[\"2017-02-06\",8.0000000000000000,3.0000000000000000,5.0000000000000000,1.6666666666666667]]}}";
        JSONObject obj = new JSONObject(response);
        JSONArray actual = obj.getJSONObject("data").getJSONArray("data");

        JSONArray expected = new JSONArray("[[\"2015-12-28\",-2,null,null,null],[\"2016-01-04\",-7.333333333333333,-2,-5.333333333333333,null],[\"2016-02-01\",4,null,null,null],[\"2016-02-08\",9,4,5,1.25],[\"2016-12-26\",1,null,null,null],[\"2017-01-02\",5,1,4,4],[\"2017-01-09\",9.5,5,4.5,0.9],[\"2017-01-30\",3,null,null,null],[\"2017-02-06\",8,3,5,1.6666666666666667]]");

        System.out.println("actual: " + actual);
        System.out.println("expected: " + expected);

        boolean failure = false;

        for(int i = 0; i < actual.length(); i++) {
            JSONArray e = expected.getJSONArray(i);
            JSONArray a = actual.getJSONArray(i);
            System.out.println(e);
            System.out.println(a);
            int l = e.length() - 1;
            System.out.println(e.get(l).toString());
            System.out.println(a.get(l).toString());
            if(!e.get(l).toString().equals("null") && !a.get(l).toString().equals("null")) {
                double elast = e.getBigDecimal(l).setScale(6, BigDecimal.ROUND_HALF_UP).doubleValue();
                double alast = a.getBigDecimal(l).setScale(6, BigDecimal.ROUND_HALF_UP).doubleValue();
                if(elast != alast) {
                    failure = true;
                    break;
                }
            }
            else if(!e.get(l).equals(a.get(l))) {
                failure = true;
                break;
            }
            for(int j =0; j < l; j++) {
                if(!e.get(j).equals(a.get(j))) {
                    failure = true;
                    break;
                }
            }
            if(failure) {
                break;
            }
        }




System.out.println(failure);






    }

    public static class TestUnirest {

        public static void main(String[] args) throws  Exception{
            String url = "https://rc.hengshi.org/api/auth/login-info";
            HttpResponse response = Unirest.get(url).headers(ImmutableMap.of("Accept", "application/json")).asString();
            Headers headers = response.getHeaders();
            System.out.println(headers);
            Object o = headers.get("csrf");
            Object cookie = headers.get("Set-Cookie").get(0);
            String csrf = cookie.toString().split(";")[0].split("=")[1];
            System.out.println(csrf);
        }
    }
}
