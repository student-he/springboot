package com.example.springboot.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Mr He
 */
public class MapUtil {

    static Map<String, Object> jsonToMap() {
        //json字符串
        String jsonStr = "{\"contend\":[{\"bid\":\"22\",\"carid\":\"0\"},{\"bid\":\"22\",\"carid\":\"0\"}],\"result\":100,\"total\":2}";
        JSONObject obj = JSON.parseObject(jsonStr);
        //map对象
        Map<String, Object> data = new HashMap<>();
        //循环转换
        Iterator it = obj.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Object> entry = (Map.Entry<String, Object>) it.next();
            data.put(entry.getKey(), entry.getValue());
        }
        System.out.println("map对象:" + data.toString());
        return data;
    }

    static JSONObject mapToJSON() {
        //map对象
        Map<String, Object> data = new HashMap<>();
        data.put("A", "1");
        data.put("B", "2");
        String x = JSONObject.toJSONString(data);
        System.out.println("json字符串:" + x);
        JSONObject obj = JSON.parseObject(x);
        return obj;
    }

    public static void main(String[] args) {
        mapToJSON();
        jsonToMap();
    }

}
