package com.lsj.colaman.quickproject.test;

import com.lsj.colaman.quickproject.base.Comparator;

/**
 * Create by kyle on 2018/9/21
 * Function :
 */
public class Data extends MultiData implements Comparator {
    public String id;
    public String name;

    public Data(String id) {
        this.id = id;
    }

    @Override
    public Object judgmentKey() {
        return id;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int getItemType() {
        return 1;
    }
}
