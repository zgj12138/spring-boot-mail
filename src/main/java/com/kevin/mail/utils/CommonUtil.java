package com.kevin.mail.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 通用工具类
 * @author ZGJ
 * @date 2017/8/24 23:27
 **/
public class CommonUtil {
    private static ObjectMapper mapper;

    public static synchronized ObjectMapper getMapperInstance(boolean createNew) {
        if(createNew) {
            return new ObjectMapper();
        } else if(mapper == null) {
            mapper = new ObjectMapper();
        }
        return mapper;
    }
}
