package com.hengshi.utils;

import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

public class JsonUtils {
    public static String toString(Object object) {
        if (object == null) {
            return null;
        }
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.setSerializationInclusion(NON_NULL);
            return mapper.writeValueAsString(object);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
