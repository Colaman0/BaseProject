package com.lsj.colaman.quickproject;

import com.lsj.colaman.quickproject.base.Comparator;

/**
 * Create by kyle on 2018/9/20
 * Function :
 */
public class Info extends Comparator {
    public String id;

    public Info(String id) {
        this.id = id;
    }

    @Override
    public Object judgmentKey() {
        return id;
    }
}
