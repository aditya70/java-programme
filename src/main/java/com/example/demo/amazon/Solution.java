package com.example.demo.amazon;

public class Solution {

    public static int countTripletSum(int size, int[] arr, int tripletSum){
        int c=0;
        for (int i=0;i<size-2;i++){
            if(tripletSum%arr[i]==0){
                for(int j=i+1;j<size-1;j++){
                    if(tripletSum%(arr[i]*arr[j])==0){
                        for(int k=j+1;k<size;k++){
                            int v=tripletSum%(arr[i]*arr[j]);
                            if(arr[k]==v) c++;
                        }
                    }
                }
            }
        }
        return c;
    }
    public static String reverseAlphabetCharsOnly(String str) {
        char[] ch = str.toCharArray();
        int r = str.length()-1, l=0;
        while (l<r){
            if (!Character.isAlphabetic(ch[l])) l++;
            else if (!Character.isAlphabetic(ch[r])) r--;
            else {
                char t=ch[l];
                ch[l]=ch[r]; ch[r]=t;
            }
            l++;
            r--;
        }
        return new String(ch);
    }
    public static void main(String[] args) {
//        System.out.println(reverseAlphabetCharsOnly("as#r"));
//        System.out.println(calculateSumOfNumbersInString("a"));
    }

    public static int countRotationsUtil(int list[], int low, int high){
        if (high<low) return 0;
        if (high==low) return low;
        int mid= low+ (high-low)/2;
        if(mid<high && list[mid+1]<list[mid]) return mid+1;
        if(low<mid && list[mid-1]>list[mid]) return mid-1;
        if (list[mid]<list[high]) return countRotationsUtil(list,low, mid);
        return countRotationsUtil(list, mid, high);
    }
    public static int countRotations(int size, int list[]){
        int res=countRotationsUtil(list, 0, size-1);
        return res;
    }
    public static int calculateSumOfNumbersInString(String str){
        int s=0;
        String t="0";
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(Character.isDigit(c)) t+=c;
            else {s+=Integer.parseInt(t);t="0";}
        }
        s+= Integer.parseInt(t);
        return s;
    }
}
