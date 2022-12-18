package com.example.demo.amazon;

import java.util.*;

public class MinimumRounds {
    public static int minimumRounds(int[] arr){
        int ans=-1;
        /*
        [2, 2, 3, 3, 2, 4, 4, 4, 4, 4]
         */
        Map<Integer, Integer> hm=new HashMap<>();
        for(int i=0;i<arr.length;i++) {
            if(hm.containsKey(arr[i])) hm.put(arr[i],1+hm.get(arr[i]));
            else hm.put(arr[i],1);
        }
        for (Map.Entry<Integer, Integer> e : hm.entrySet()){
            int v=e.getValue();
            if(v%3==1 && v%2==1) return -1;
            else if (v%3==0) ans+= v/3;
            else ans+=(v/3)+1;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr=new int[]{2, 2, 3, 3, 2, 4, 4, 4, 4, 4};
        int ans= minimumRounds(arr);
        System.out.println(ans);
    }
}
