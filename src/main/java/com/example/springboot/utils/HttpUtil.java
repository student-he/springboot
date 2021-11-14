package com.example.springboot.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author zhengwei he
 *
 *
 */

public class HttpUtil {

    /**
     * 发送Http请求，数据格为form表单格式    *
     * @param url
     * @param param
     * @return
     * @throws Exception
     */
    public static JSONObject doHttpPost(String url, Map<String, String> param) throws Exception {
        JSONObject returnJSoN = new JSONObject();
        StringBuilder result = new StringBuilder("");
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost(url.trim());
            List<BasicNameValuePair> nvpList = new ArrayList<BasicNameValuePair>();
            if (param != null && !param.isEmpty()) {
                Iterator<String> keyIterator = param.keySet().iterator();
                while (keyIterator.hasNext()) {
                    String key = keyIterator.next();
                    nvpList.add(new BasicNameValuePair(key, param.get(key)));
                }
            }
            httpPost.setEntity(new UrlEncodedFormEntity(nvpList, Consts.UTF_8));
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(5000).build();
            httpPost.setConfig(requestConfig);
            try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
                returnJSoN.put("statusCode", response.getStatusLine().getStatusCode());
                returnJSoN.put("response", "");
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    try (BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent(), Consts.UTF_8))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            result.append(line);
                        }
                    }

                    returnJSoN.put("response", result.toString());
                }

            }
        }
        return returnJSoN;
    }

}