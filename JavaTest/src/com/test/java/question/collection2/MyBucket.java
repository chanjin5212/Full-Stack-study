package com.test.java.question.collection2;

import java.util.ArrayList;

public class MyBucket {
    private ArrayList<MyKeyValue> list;

    public MyBucket() {
        this.list = new ArrayList<MyKeyValue>();
    }

    public ArrayList<MyKeyValue> getList() {
        return this.list;
    }
}
