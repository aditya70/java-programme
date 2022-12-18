package com.example.demo.archive.oa1;

import java.util.*;

// https://www.geeksforgeeks.org/minimum-increment-operations-to-make-array-unique/
public class TiktokTwo {
    // LC 945
    public static void main(String[] args) {

    }
    public static int getMinimumUniqueSum(List<Integer> arr) {
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        HashSet<Integer> usedSet = new HashSet<Integer>();
        for (int i : arr) {
            if (map.containsKey(i))
                map.put(i, map.get(i) + 1);
            else {
                map.put(i, 1);
                usedSet.add(i);
            }
        }
        int maxUsed = 0, sum=0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int freq = entry.getValue();
            sum += key;
            if (freq <= 1)  {
                continue;
            }
            int duplicate = freq - 1;
            int cur = Math.max(key + 1, maxUsed);
            while (duplicate > 0) {
                if (!usedSet.contains(cur)) {
                    usedSet.add(cur);
                    duplicate--;
                    maxUsed = cur;
                    sum += maxUsed;
                }
                cur++;
            }
        }
        return sum;

    }
}
