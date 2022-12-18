package com.example.demo.hackerrank;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class MaximumSubarraySum {
    public static long maximumSum(List<Long> a, long m) {
        // Write your code here
        long max = 0, curr = 0;
        TreeSet<Long> tree = new TreeSet<>();

        for(int i=0; i<a.size(); i++){
            curr = (curr + a.get(i) % m) % m;
            max = Math.max(curr, max);
            long higher = 0L;

            try{
                higher = tree.higher(curr);
            }
            catch(Exception e){}

            if(higher != 0L){
                max = Math.max(max, (curr-higher+m)%m);
            }

            tree.add(curr);
        }
        return max;
    }
    public static void main(String[] args) {
        long ans=maximumSum(Arrays.asList(3L,3L,9L,9L,5L),7L);
        System.out.println(ans);
    }
}
