package com.hengshi.test.application;

import com.hengshi.test.base.BaseTest;
import com.hengshi.test.connection.ConnectionCreateTest;
import com.hengshi.test.models.App;
import com.hengshi.utils.Constants;
import com.hengshi.utils.HttpClientSession;
import com.hengshi.utils.LoginUtils;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author wgy on 2018/11/29
 */
@RunWith(DataProviderRunner.class)
public class ApplicationCreateTest extends BaseTest {
    private static final Logger log = Logger.getLogger(ConnectionCreateTest.class);
    private static HttpClientSession httpcs = new HttpClientSession();

    @DataProvider
    public static Object[][] dataProvider() {
        return new Object[][]{
            {
                "Create app: title: special chars",
                 "~!@#$%^&*()_+{}|[],.<>?`~",
            },
            {
                "Create app: title: chinese chars",
                "测试应用中文标题",
            },
            {
                "Create app: title: long text",
                 "长标题QWERTYUIOPSDFGHJKLXCVBNM《QWERTYUIOFGHJKZXCVBNM《WERTYUIOZXCVBNM《ERTYUIXCVBNM",
            }

        };


    }

    @Test
    @UseDataProvider("dataProvider")
    public void testApplicationCreate(String testcase, String appname) throws Exception {
        String body = new App(appname).toString();
        doPost(testcase, httpcs, config.getAppCreateUrl(), body, 200);

    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        LoginUtils.login(httpcs);

    }


    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        LoginUtils.close(httpcs);


    }


}
