package com.example.demo.archive.oa;

import java.util.*;

class Comp implements Comparator<Pair11>{

    @Override
    public int compare(Pair11 o1, Pair11 o2) {
          int v = o2.a-o1.a;
          if (v==0) return o1.b-o2.b;
          return v;
    }
}

class Pair11 {
    int a,b;

    public Pair11(int a, int b) {
        this.a = a;
        this.b = b;
    }
}
public class SamsaraTwo {
    public static int[] solution(int[] packs, int[] containers){
        int n=packs.length, m=containers.length;
        int[] ans = new int[n];
        ArrayList<Pair11> pck= new ArrayList<>();
        ArrayList<Pair11> cntr= new ArrayList<>();
        for(int i=0;i<n;i++) {
            Pair11 p = new Pair11(packs[i], i);
            pck.add(p);
        }
        for(int i=0;i<m;i++) {
            Pair11 p = new Pair11(containers[i], i);
            cntr.add(p);
        }

        Collections.sort(pck, new Comp());
        Collections.sort(cntr, new Comp());
        int i=0, k =0;
        for (Pair11 p : pck) {
            int a = p.a;
            if (a <= cntr.get(i).a) {
                ans[k++]=cntr.get(i++).b;
            } else {
                ans[k++]=-1;
            }
        }
        return  ans;
    }

    public static int[] solution1(int[] packs, int[] containers) {
        int n=packs.length, m=containers.length;
        int[] ans = new int[n];
        int k=0;
        for (int i=0;i<n;i++) {
            int f = 0;
            for (int j=0;j<m;j++){
                if (packs[i]<=containers[j]) {
                    ans[k++]=j;
                    containers[j]=-1;
                    f = 1;
                    break;
                }
            }
            if (f==0){
                ans[k++]=-1;
            }
        }
        return  ans;

    }
    public static void main(String[] args) {
//        int[] p = new int[]{12,5,5};
//        int[] c = new int[]{5,4,15,3};
        int[] p = new int[]{1000,10,1,1};
        int[] c = new int[]{12,12,1,1};
//        int[] p = new int[]{5};
//        int[] c = new int[]{2,3,4,8,1,11};
        int a[] = solution1(p,c);
        for (int v : a) System.out.print(v+" ");
//        System.out.println(a.toString());
    }
}
