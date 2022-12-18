package com.example.demo.archive.oa;

import java.util.PriorityQueue;

public class AmazonOne {
    public static void main(String[] args) {
        System.out.println(minKyepadClickCount("abcghdiefjoba"));
    }
    private static int minKyepadClickCount(String text ) {
        int[] freqArr = new int[26];
        for (char c: text.toCharArray()) {
            freqArr[c-'a']++;
        }
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a, b) -> b-a);
        for (int f: freqArr) {
            if (f == 0) continue;
            maxPQ.add(f);
        }
        int minStrokes = 0;
        int i = 0, size = maxPQ.size();
        while (i<size) {
            int f = maxPQ.poll();
            if (i<9) {
                minStrokes += f;
            } else if (i < 18) {
                minStrokes += 2*f;
            } else {
                minStrokes += 3*f;
            }
            i++;
        }
        return minStrokes;
    }
}
