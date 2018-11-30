package com.hengshi.utils;

import com.google.common.collect.ImmutableMap;
import com.hengshi.test.config.Configuration;
import com.hengshi.test.models.Chart;
import com.hengshi.test.models.ChartOptions;
import com.hengshi.test.models.Layout;

/**
 * @author wgy on 2018/11/29
 */
public class Constants {
    public static String ENCODING_UTF8 = "UTF-8";
    public static String httpDomain = new Configuration().getDomain();
    public static String layoutsVersion = "24*12";
    public static String POST = "post";
    public static String GET = "get";
    public static String DELETE = "delete";
    public static String PUT = "put";
    public static int CHECKDSSTATUSCOUNTER = 1000;
    public static int DATASETREADY = 3;

}
