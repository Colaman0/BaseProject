package com.lsj.colaman.quickproject.http;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.lsj.colaman.quickproject.base.ApiConstants;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Create by kyle on 2018/9/24
 * Function :
 */
public class API implements ApiInterface {
    ApiInterface mApi;

    private API() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mApi = retrofit.create(ApiInterface.class);
    }

    public static API getInstance() {
        return Holder.instance;
    }

    @Override
    public Observable<Object> getA() {
        return mApi.getA();
    }

    private static class Holder {
        private final static API instance = new API();
    }
}
