package com.example.demo.archive.oa;

import java.util.Arrays;
import java.util.List;

public class JPMCTwo {
    public List<Integer> f(List<Integer> elements) {
        Integer[] arr=new Integer[elements.size()];
        for(int i=0;i<elements.size();i++) arr[i]=elements.get(i);
        Arrays.sort(arr, (a,b) -> Integer.bitCount(a) == Integer.bitCount(b) ? a-b : Integer.  bitCount(a)-Integer.bitCount(b));
        return Arrays.asList(arr);
    }
    public static void main(String[] args) {

    }
}
