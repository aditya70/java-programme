package com.example.demo.pr.lc;

import java.util.*;

class _015_3_Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        Set<List<Integer>> as= new HashSet<>();
        for(int i=0;i<nums.length;i++){
            int target= 0-nums[i];
            //  System.out.println("target " + target + " " + nums[i]);
            Set<List<Integer>> s= new HashSet<>();
            Map<Integer, Integer> hm = new HashMap<>();
            for (int j=i+1;j<nums.length;j++){
             //   System.out.println("cc " + (target-nums[j]) + "" );
                if(hm.containsKey(target-nums[j])){
                   // System.out.println("in " + hm.get(target-nums[j]) + " " + j);
                    List<Integer> l=new ArrayList<>();
                    l.add(nums[i]);l.add(target-nums[j]);l.add(nums[j]);
                    Collections.sort(l);
                    s.add(l);
                }
                hm.put(nums[j],j);
                // System.out.println("hm " + nums[j] + " " + j);
            }
            if(s.size()>0) {
              //  System.out.println("s size " + s.size() );
                as.addAll(s);
            }
        }
        if(as.size()>0) {
            for(List<Integer> li:as) ans.add(li);
        }
        return ans;
    }
}