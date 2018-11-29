package com.hengshi.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 * @author wgy on 2018/11/28
 */

public class PropertiesUtils {

    private Properties properties = new Properties();

    public PropertiesUtils() {
    }

    public Properties load(String path) {
        try {
            InputStream stream = new FileInputStream(path);
            properties.load(stream);
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
