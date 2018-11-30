package com.hengshi.test.tonghuanbi;

import com.hengshi.test.base.BaseTest;
import com.hengshi.test.connection.ConnectionCreateTest;
import com.hengshi.test.constants.FileDataset;
import com.hengshi.test.models.App;
import com.hengshi.utils.HttpClientSession;
import com.hengshi.utils.LoginUtils;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author wgy on 2018/11/30
 */
public class TestTonghuanbi_nonTimeDimension extends BaseTest {
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
        String name = "testTonghuanbi" + System.currentTimeMillis();
        LoginUtils.login(httpcs);
        int appid = prepareApp(httpcs, name);
        int dsbid = prepareDashboard(httpcs, appid, name);
        String filepath = "filter.csv";
        int dsid = createLocalFileDataset(httpcs,appid,filepath,FileDataset.filter);
        checkDatasetReady(httpcs, appid, dsid);


    }


    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        LoginUtils.close(httpcs);


    }

}
