package com.lsj.colaman.quickproject.sample;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.lsj.colaman.quickproject.test.MultiData;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Create by kyle on 2019/2/17
 * Function :
 */
public class LiveDataCreater {
    public static MutableLiveData<String> livedata = new MutableLiveData();

    public static MutableLiveData<String> getLiveData() {
        return livedata;
    }

    public static void sendData() {

    }
}