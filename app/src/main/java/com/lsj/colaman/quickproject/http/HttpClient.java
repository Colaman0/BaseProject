package com.lsj.colaman.quickproject.http;

import okhttp3.OkHttpClient;

/**
 * Create by kyle on 2018/9/24
 * Function : okhttp设置
 */
public class HttpClient {
    private OkHttpClient mOkHttpClient;

    private HttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        mOkHttpClient = builder.build();
    }

    public static HttpClient getInstance() {
        return Holder.instance;
    }

    public OkHttpClient getOkHttpClient() {
        return mOkHttpClient;
    }

    private static class Holder {
        private final static HttpClient instance = new HttpClient();
    }
}
