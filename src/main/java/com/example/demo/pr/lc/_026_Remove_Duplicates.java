package com.example.demo.pr.lc;

public class _026_Remove_Duplicates {

    public int removeDuplicates(int[] nums) {
        int e=nums.length,c=0;
        for(int i=1;i<e;i++){
            if(nums[c]!=nums[i]) {
                nums[++c]=nums[i];
            }
        }
        return c+1;
    }
}
