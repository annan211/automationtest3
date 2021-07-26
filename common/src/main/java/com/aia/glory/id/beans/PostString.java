package com.aia.glory.id.beans;

import com.aia.glory.id.utils.HttpClientUtil;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PostString {

    public String execute(String path, String json) {
        String response = null;

        try (CloseableHttpClient httpClient = HttpClientUtil.createHttpClient()) {

            HttpPost httpPost = new HttpPost(path);

            StringEntity se = new StringEntity(json.toString());
            se.setContentType("application/json");

            httpPost.setEntity(se);

            try (CloseableHttpResponse httpResponse = httpClient.execute(httpPost)) {

                HttpEntity entity = httpResponse.getEntity();
                response = EntityUtils.toString(entity, "UTF-8");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

}
