package com.example.demo.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class PascalTriangleDecryption {
    static int decryptPascalTriangle(ArrayList<Integer> arr){
        while (arr.size() > 2){
            ArrayList<Integer> ar = new ArrayList();
            for(int i=0; i<arr.size()-1;i++){
                ar.add((arr.get(i)+arr.get(i+1))%10);
            }
            arr=ar;
        }
        int s=0;
        for(int i:arr) s+=i;
        return s>=10 ? s%10 :s;
    }
    public static void main(String[] args) {
        Integer[] ar = new Integer[]{4,5,6,7};
        int a= decryptPascalTriangle(new ArrayList<>(Arrays.asList(ar)));
        System.out.println(a);
    }
}
