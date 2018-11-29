package com.hengshi.test.dataset;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

/**
 * @author wgy on 2018/11/28
 */

@RunWith(DataProviderRunner.class)
public class TestDatasetDelete {
    @DataProvider
    public static Object[][] dataProvider() {
        return new Object[][]{


        };

    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        // Prepare dataset to be deleted


    }



    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }


    @Test
    @UseDataProvider("dataProvider")
    public void testAuditApi(String testcase, String params,int code, Object payload) throws Exception{
    }

}
