package com.test.java.question.collection2;

import java.util.ArrayList;

public class MyHashMap {

    private MyBucket[] buckets;
    private int size;
    
    public MyHashMap() {
        this.buckets = new MyBucket[16];
    }

    public void put(String key, String value) {
        int i = key.hashCode() % this.buckets.length;
        if(this.buckets[i] == null)
            this.buckets[i] = new MyBucket();

        MyKeyValue myKeyValue = getMyKeyValue(key);
        
        if(myKeyValue == null) {
            MyKeyValue newKeyValue = new MyKeyValue(key, value);
            this.buckets[i].getList().add(newKeyValue);
            this.size++;
        }
        else {
            myKeyValue.setValue(value);
        }
    }

    private MyKeyValue getMyKeyValue(String key) {
        int i = key.hashCode() % this.buckets.length;
        ArrayList<MyKeyValue> list = this.buckets[i].getList();
        
        for(MyKeyValue e : list) {
            if (e.getKey().equals(key))
                return e;
        }

        return null;
    }

    public String get(String key) {
        return getMyKeyValue(key) == null ? null : getMyKeyValue(key).getValue();
    }

    public int size() {
        return this.size;
    }

    public String remove(String key) {
        int i = key.hashCode() % this.buckets.length;
        ArrayList<MyKeyValue> list = this.buckets[i].getList();
        String value = null;

        for(MyKeyValue e : list) {
            if(e.getKey().equals(key)) {
                value = e.getValue();
                list.remove(e);
                size--;
                break;
            }
        }

        return value;
    }

    public boolean containKey(String key) {
        return getMyKeyValue(key) != null;
    }

    public boolean containsValue(String value) {
        for(MyBucket myBucket : this.buckets) {
            if(myBucket != null) {
                for(MyKeyValue e : myBucket.getList()) {
                    if(e.getValue().equals(value))
                        return true;
                }
            }
        }
        return false;
    }

    public void clear() {
        this.buckets = new MyBucket[16];
        size = 0;
    }
}
