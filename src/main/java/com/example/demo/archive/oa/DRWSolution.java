package com.example.demo.archive.oa;

// you can also use imports, for example:

import java.util.*;
import java.util.ArrayList;


// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class DRWSolution {
    List<List<Integer>> ss = new ArrayList<>(new ArrayList<>());
    int c = 0;
    int ts = 0;

    public String solution(int[] A) {
        // write your code in Java SE 8
        ss = new ArrayList<>(new ArrayList<>());
        c = 0;
        ts = 0;
        int s = sum(A) / 3;
        return subset(A, s);
    }

    public String subset(int[] arr, int sum) {
        int n = arr.length;
        ArrayList<Integer> subSet = new ArrayList<>();
        char[] res = new char[arr.length];
        char[] clr = {'R', 'G', 'B'};
        int col = 0;
        int sumSet = sum(arr);
        if (isSubsetSum(Arrays.copyOf(arr, arr.length), n, sum, subSet) && sumSet == ts) {
            for (List<Integer> v : ss) {
                for (Integer i : v) {
                    res[indexofArr(arr, i)] = clr[col];
                    c++;
                }
                col++;
            }
        } else {
            return "impossible";
        }
        return new String(res);
    }

    public int sum(int[] arr) {
        int res = 0;
        for (int i : arr) res += i;
        return res;
    }

    public boolean isSubsetSum(int[] set, int n, int sum, List<Integer> subset) {
        if (sum == 0) {
            ss.add(new ArrayList<>());
            for (Integer integer : subset) {
                ss.get(c).add(integer);
                delEle(set, integer);
                ts += integer;
            }
            c++;
            return true;
        }
        if (n == 0) {
            return false;
        }
        if (set[n - 1] > sum)
            return isSubsetSum(set, n - 1, sum, subset);
        boolean exc = isSubsetSum(set, n - 1, sum, subset);
        ArrayList<Integer> v1 = new ArrayList<>(subset);
        v1.add(set[n - 1]);
        boolean inc = isSubsetSum(set, n - 1, sum - set[n - 1], v1);
        return exc || inc;
    }

    public void delEle(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == k) {
                arr[i] = Integer.MAX_VALUE;
                break;
            }
        }
    }

    public int indexofArr(int[] arr, int k) {
        int res = -1;
        for (int i = 0; i < arr.length; ++i) {
            if (k == arr[i]) {
                res = i;
                arr[i] = Integer.MAX_VALUE;
                break;
            }
        }
        return res;
    }
}

