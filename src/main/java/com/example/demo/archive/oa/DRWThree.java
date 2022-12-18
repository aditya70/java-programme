package com.example.demo.archive.oa;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

public class DRWThree {
    public static void f(){

    }
    public static void main(String[] args) {
        Vector<Vector<Integer>> subsets = new Vector<>(new Vector<>());
    }
    public String solution(int[] A) {
        String finalOP = "impossible";
        String[] colored = new String[A.length];
        int k = 3;
        List<Integer> numbers = Arrays.stream(A).boxed().collect(Collectors.toList());
        Integer arrSum = numbers.stream().reduce(0, ((a, b) -> a + b));
        if (arrSum % k == 0 && A.length >= k) {
            int requiredSumOfSubset = arrSum / k;
            colored = fillColor(colored, A, requiredSumOfSubset, 0, "R");
            colored = fillColor(colored, A, requiredSumOfSubset, 0, "G");
            colored = fillColor(colored, A, requiredSumOfSubset, 0, "B");
            if (colored.length > 0) {
                StringBuilder sb = new StringBuilder();
                for (String str : colored)
                    sb.append(str);
                finalOP = sb.toString();
            }
        }
        return finalOP;
    }

    public String[] fillColor(String[] colored, int[] arr, int requiredSum, int currVal, String color) {
        boolean added = false;
        for (int idx = 0; idx < colored.length; idx++) {
            if (colored[idx] == null) {
                int tempSum = currVal + arr[idx];
                if (tempSum == requiredSum) {
                    added = true;
                    colored[idx] = color;
                    break;
                } else if (tempSum < requiredSum) {
                    String[] newColored = colored;
                    newColored[idx] = color;
                    String[] retColored = fillColor(newColored, arr, requiredSum, tempSum, color);
                    if (retColored.length > 0) {
                        added = true;
                        colored = retColored;
                        break;
                    }
                }
            }
        }

        String[] arrNew = new String[0];
        return added ? colored : arrNew;
    }
}
