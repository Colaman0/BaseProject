package com.lsj.colaman.quickproject.http;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Create by kyle on 2018/9/24
 * Function :
 */
public interface ApiInterface {
    @GET("xiandu/data/id/appinn/count/10/page/1 ")
    Observable<Object> getA();
}
