package com.example.demo.pr.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestOne {

    static class Item {
        public Integer a,b;

        public Item(Integer a, Integer b) {
            this.a = a;
            this.b = b;
        }
    }

    static class Comp implements Comparator<Item> {

        @Override
        public int compare(Item o1, Item o2) {
            return o1.a-o2.a;
        }
    }
    public static void main(String[] args) {
        List<Item> list = new ArrayList<>();
        Item item = new Item(12, 30);
        Item item1 = new Item(15, 27);
        Item item2 = new Item(8, 18);
        list.add(item);
        list.add(item1);
        list.add(item2);
        Collections.sort(list, new Comp());
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).a + " " +list.get(i).b);
        }
    }
}
