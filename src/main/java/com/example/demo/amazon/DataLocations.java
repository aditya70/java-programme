package com.example.demo.amazon;

import java.util.*;

public class DataLocations {
    static void dataLocations(int[] locations, int[] movedFrom, int[] movedTo){
        Map<Integer, Integer> hm=new HashMap<>();
        for(int i=0;i<locations.length;i++) hm.put(locations[i],i);
        for(int i=0;i<movedFrom.length;i++) {
            if (hm.containsKey(movedFrom[i])){
                int v= hm.get(movedFrom[i]);
                hm.remove(movedFrom[i]);
                hm.put(movedTo[i],v);
            }
        }
        Set<Integer> k=hm.keySet();
        List<Integer> l=new ArrayList<>(k);
        Collections.sort(l);
        System.out.println(l);
    }
    public static void main(String[] args) {
        int[] locations=new int[]{1,7,6,8};
        int[] movedFrom=new int[]{1,7,2};
        int[] movedTo=new int[]{2,9,5};
        dataLocations(locations, movedFrom, movedTo);
    }
}
