package com.example.demo.archive.oa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GSOne {
    public static long m() {
        List<Integer> songs = new ArrayList<>();
        Map<Integer, Integer> hm = new HashMap<>();
        long ans = 0;
        for (int s : songs) {
            if (hm.containsKey(((60 - s % 60)) % 60)) {
                ans += hm.get((60 - s % 60) % 60);
            }
            hm.put(s % 60, hm.getOrDefault(s % 60, 0) + 1);
        }
        return ans;
    }
    public static void main(String[] args) {

    }
}
