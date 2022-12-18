package com.example.demo.archive.oa;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class JPMCOne {
    public static int f(List<Integer> num){
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(Integer i : num)  q.offer(i);
        int t = 0;
        int ans = 0;
        while(q.size() > 1){
            int f = q.poll();
            int s = q.poll();
            t = f + s;
            ans += t;
            q.offer(t);
        }
        return ans;
    }
    public static void main(String[] args) {
        List<Integer> num= Arrays.asList(1,2,3);
        System.out.println(f(num));
    }
}
