package com.example.demo.archive.oa;

import java.util.HashMap;

class HashMapUtil {
    HashMap<Integer, Integer> hashMap;
    Integer key, value;
    public HashMapUtil() {
        this.hashMap = new HashMap<>();
        this.key = 0;
        this.value = 0;
    }
    public void insert(int x, int y) {
        this.hashMap.put(x - this.key, y-this.value);
    }
    public int get(int x) {
        return this.hashMap.get(x- key) + this.value;
    }
    public void addToKey(int n) {
        this.key += n;
    }
    public  void addToValue(int n) {
        this.value += n;
    }
}
public class SIG1 {
    long solution(String[] queryType, int[][] query) {
        long sum = 0;
        HashMapUtil hashMapUtil = new HashMapUtil();
        for (int i = 0; i < queryType.length; i++) {
            int[] args = query[i];
            String type = queryType[i];

            switch (type) {
                case "get":
                    int res = hashMapUtil.get(args[0]);
                    sum += res;
                    break;
                case "insert":
                    hashMapUtil.insert(args[0], args[1]);
                    break;
                case "addToKey":
                    hashMapUtil.addToKey(args[0]);
                    break;
                case "addToValue":
                    hashMapUtil.addToValue(args[0]);
                    break;
            }
        }
        return sum;
    }
}

