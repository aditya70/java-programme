package com.example.demo.pr.lc;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums){
        int len=nums.length;
        LinkedHashSet<Integer> hs =new LinkedHashSet<>();
       for (int i=0;i<nums.length;i++) hs.add(nums[i]);
        Iterator<Integer> itr = hs.iterator();
        int i=0;
        while(itr.hasNext()){
            nums[i]= itr.next();
            i++;
        }
       return hs.size();
    }
    public static void main(String[] args) {
        int[] arr= new int[] {1,1,2};
        int ans=removeDuplicates(arr);
        System.out.println(ans);
    }
}
