package com.example.demo.archive.oa1;
import java.util.*;
class IncOperation {
    static int minIncrementForUnique(int[] A)  {
        TreeMap<Integer, Integer> dict = new TreeMap<Integer, Integer>();
        HashSet<Integer> used = new HashSet<Integer>();
        for (int i : A) {
            if (dict.containsKey(i))
                dict.put(i, dict.get(i) + 1);
            else {
                dict.put(i, 1);
                used.add(i);
            }
        }
        int maxUsed = 0, ans = 0, s=0;
        for (Map.Entry<Integer, Integer> entry : dict.entrySet()) {
            int value = entry.getKey();
            int freq = entry.getValue();
            System.out.println("key " + value + " freq "+ freq);
            s += value;
            System.out.println(" s1 "+s);

            if (freq <= 1)  {

                continue;
            }
            int duplicates = freq - 1;
//            int duplicates = freq;
//            if (duplicates ==1 ){
//                s += value;
//                System.out.println(" s2 "+s);
//            }
            int cur = Math.max(value + 1, maxUsed);
            while (duplicates > 0) {
                if (!used.contains(cur)) {
//                    ans += cur - value;
                    used.add(cur);
                    duplicates--;
                    maxUsed = cur;
                    s += maxUsed;
                    System.out.println(" s3 "+s);
                }
                cur++;
            }
        }
        System.out.println(" ans s is "+s);
        return ans;
//        return ans;
    }

    static int minIncrementForUnique1(List<Integer> arr)  {
        TreeMap<Integer, Integer> dict = new TreeMap<Integer, Integer>();
        HashSet<Integer> used = new HashSet<Integer>();
        for (int i : arr) {
            if (dict.containsKey(i))
                dict.put(i, dict.get(i) + 1);
            else {
                dict.put(i, 1);
                used.add(i);
            }
        }
        int maxUsed = 0, ans = 0, s=0;
        for (Map.Entry<Integer, Integer> entry : dict.entrySet()) {
            int value = entry.getKey();
            int freq = entry.getValue();
            System.out.println("key " + value + "freq "+ freq);
            if (freq <= 1)  {
                s += value;
                continue;
            }
            int duplicates = freq - 1;
            int cur = Math.max(value + 1, maxUsed);
            while (duplicates > 0) {
                if (!used.contains(cur)) {
                    ans += cur - value;
                    used.add(cur);
                    duplicates--;
                    maxUsed = cur;
                    s += maxUsed;
                }
                cur++;
            }
        }
        return s;
    }
    public static void main(String[] args)  {
//        int[] A = { 3, 2, 1, 2, 1, 2, 6, 7 };
//        int[] A = { 3, 2, 1, 2, 7 };
        int[] A = { 1, 2, 2};
        System.out.print(minIncrementForUnique(A));
    }
}

