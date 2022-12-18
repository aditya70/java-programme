package com.example.demo.archive.oa;

import java.util.*;

class GSTwo {
    public static List<Integer> getQueryResults(long n, List<List<Integer>> queries) {
        List<Integer> ans = new ArrayList<>();
        for (List<Integer> query : queries) {
            int l = query.get(0), r = query.get(1),m = query.get(2);
            long res = sol(n, l, r, m) % m;
            int result = (int) res % m;
            ans.add(result);
        }
        return ans;
    }
    public static long sol(long n, int l, int r, int m) {
        List<Long> li = goodArr(n);
        List<Long> mli = new ArrayList<>();
        for (int i = l; i <= r; ++i) {
            long mo = li.get(li.size() - i) % m;
            mli.add(mo);
        }
        long pro = 1;
        int k = 0;
        while (k < mli.size()) {
            pro *= mli.get(k++);
            if (pro > m) {
                pro %= m;
            }
        }
        return pro % m;
    }

    public static List<Long> goodArr(long n) {
        long twoPow = 1;
        int lPow = 0;
        while (twoPow * 2 < n) {
            twoPow *= 2;
            lPow++;
        }
        List<Long> li = new ArrayList<>();
        while (n > 0 && lPow >= 0) {
            long v = twoPow(lPow--);
            if (n - v >= 0) {
                li.add(v);
                n -= v;
            }
        }
        return li;
    }
    public static long twoPow(int pow) {
        long r = 1;
        for (int i = 0; i < pow; ++i) {
            r *= 2;
        }
        return r;
    }
}


