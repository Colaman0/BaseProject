package com.lsj.colaman.quickproject.test;

import com.lsj.colaman.quickproject.base.Comparator;

/**
 * Create by kyle on 2018/9/21
 * Function :
 */
public class DataRight extends MultiData implements Comparator {
    public String className;
    public String num;

    public DataRight(String className) {
        this.className = className;
    }

    @Override
    public Object judgmentKey() {
        return className;
    }

    @Override
    public int getItemType() {
        return 2;
    }

    @Override
    public String toString() {
        return "DataRight{" +
                "className='" + className + '\'' +
                ", num='" + num + '\'' +
                '}';
    }
}
