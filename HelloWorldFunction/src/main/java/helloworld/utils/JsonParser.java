package helloworld.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParser {

    public static String toJson(Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
