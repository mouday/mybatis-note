package com.atguigu.mybatis.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
    /**
     * 美化输出
     */
    public static void prettyPrint(Object obj) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
