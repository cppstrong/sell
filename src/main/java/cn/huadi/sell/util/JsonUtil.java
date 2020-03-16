package cn.huadi.sell.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author 蔡鹏
 * 2020/3/14
 * @version 1.0.0
 * @Description TODO
 */
public class JsonUtil {

    public static String toJson(Object object) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}
