package com.example.demo.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumMove {
    static int minMove(int[] arr){
        int n=arr.length, a=0;
        for (int i=0;i<n-1;i++){
            for (int j=i+1;j<n;j++){
                if(arr[i]>arr[j]) {
                    int t=arr[i];
                    arr[j]=arr[i];
                    arr[i]=t;
                    a++;
                }
            }
        }
        return a;
    }
    public static void main(String[] args) {
        int[] arr=new int[]{3,2,1};
        int ans=minMove(arr);
        System.out.println(ans);
    }
}
