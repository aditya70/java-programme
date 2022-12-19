package com.example.demo.pr.lc;

import java.util.HashMap;
import java.util.Map;

class _001_Two_Sum {
    public int[] twoSum(int[] nums, int target) {
        int[] ans=new int[2];
        Map<Integer, Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(target-nums[i])){
                System.out.println(target-nums[i] + " " + i);
                ans[0]=hm.get(target-nums[i]); ans[1]=i;
                break;
            }
            hm.put(nums[i],i);
        }
        return ans;
    }
}