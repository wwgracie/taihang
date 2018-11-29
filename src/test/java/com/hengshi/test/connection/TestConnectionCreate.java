package com.hengshi.test.connection;

import com.hengshi.test.base.TestBase;
import com.hengshi.test.models.Connection;
import com.hengshi.utils.HttpClientSession;
import com.hengshi.utils.LoginUtils;
import com.jayway.jsonpath.JsonPath;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * @author wgy on 2018/11/28
 */
@RunWith(DataProviderRunner.class)
public class TestConnectionCreate extends TestBase {
    private static final Logger log = LogManager.getLogger(TestConnectionCreate.class);
    private static HttpClientSession httpcs = new HttpClientSession();

    @DataProvider
    public static Object[][] dataProvider() {
        return new Object[][]{
                {"mysql", "192.168.2.250", 3380, "test", "test", "test", "UTF-8", "Database"},
                {"postgresql", "192.168.2.250", 5410, "postgres", "postgres", "postgres", "UTF-8", "Database"},
                {"sqlserver", "192.168.2.250", 14317, "sa", "Passw0rd#1", "test", "UTF-8", "Database"},
                {"oracle", "192.168.2.250", 15211, "qogir", "12345678", "xe", "UTF-8", "Database"},
                {"tidb", "192.168.2.250", 40200, "root","", "test", "UTF-8", "Database"},
                {"cloudera_impala", "192.168.2.250", 21210, "hadoop","" , "default", "UTF-8", "SQL on Hadoop"},
                {"spark_sql", "192.168.2.250", 10230, "hadoop","" , "default", "UTF-8", "SQL on Hadoop"},
                {"hive", "192.168.2.250", 10022, "hadoop","" , "default", "UTF-8", "SQL on Hadoop"}

        };

    }

    @Test
    @UseDataProvider("dataProvider")
    public void prepareConnection(String type, String host, int port, String username, String password, String database, String
            encoding, String category) throws Exception {
        String url = config.getConnectionCreateUrl();
        String connname = type + System.currentTimeMillis();
        String conn = new Connection(connname).type(type).host(host).port(port).username(username).password(password).database(database).encoding(encoding).category(category).toString();
        System.out.println(conn);
        String response = httpcs.post(url, conn);
        System.out.println(response);
        int connectionId = JsonPath.read(response, "$.data.id");
        System.out.println(connectionId);
        String fileName = "config/connection.properties";
        OutputStream f = new FileOutputStream(fileName, true);
        PrintStream p = new PrintStream(f);
        p.println(type + "," + connectionId);
        p.close();
        f.close();
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
