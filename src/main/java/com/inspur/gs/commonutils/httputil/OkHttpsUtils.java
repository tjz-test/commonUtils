package com.inspur.gs.commonutils.httputil;

import okhttp3.*;
import java.io.IOException;

/**
 * @author 14791
 */
public class OkHttpsUtils {

    /**
     * 消息转发
     * @param url url
     * @param in0 input param
     * @return message
     */
    public static String okHttpsFunc(String url,String in0) throws IOException {
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/xml");
        RequestBody body = RequestBody.create(mediaType, in0);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .addHeader("X-ECC-Current-Tenant", "919455")
                .addHeader("Content-Type", "application/xml")
                .addHeader("cache-control", "no-cache")
                .addHeader("accept", "*/*")
                .addHeader("Authorization", "Bearer aaaaaa")
                .build();

        Response response = client.newCall(request).execute();
        return response.message();
    }

}
