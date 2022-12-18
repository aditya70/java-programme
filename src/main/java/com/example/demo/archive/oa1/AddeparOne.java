package com.example.demo.archive.oa1;

import java.util.*;

class SortItemComp1 implements Comparator<Item> {

    @Override
    public int compare(Item o1, Item o2) {
        return o1.a.compareTo(o2.a);
    }
}

class SortItemComp2 implements Comparator<Item> {

    @Override
    public int compare(Item o1, Item o2) {
        return o1.b.compareTo(o2.b);
    }
}

class SortItemComp3 implements Comparator<Item> {

    @Override
    public int compare(Item o1, Item o2) {
        return o1.c.compareTo(o2.c);
    }
}

class SortItemComp4 implements Comparator<Item> {

    @Override
    public int compare(Item o1, Item o2) {
        return o2.a.compareTo(o1.a);
    }
}

class SortItemComp5 implements Comparator<Item> {

    @Override
    public int compare(Item o1, Item o2) {
        return o2.b.compareTo(o1.b);
    }
}

class SortItemComp6 implements Comparator<Item> {

    @Override
    public int compare(Item o1, Item o2) {
        return o2.c.compareTo(o1.c);
    }
}
class Item {
    public String a,b,c;

    public Item(String a, String b, String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}
public class AddeparOne {

    public static void main(String[] args) {

    }

    public static List<String> fetchItemsToDisplay(List<List<String>> items, int sortParameter, int sortOrder, int itemsPerPage, int pageNumber) {
        System.out.println(" " + items.size() + " " + sortParameter + " " +sortOrder + " " + itemsPerPage + " " +pageNumber);
        List<String> ans = new ArrayList<>();
        List<Item> itemsList = new ArrayList<>();
        for( int i=0;i<items.size();i++) {
            ArrayList<Item> ar = new ArrayList<>();
            List<String> s = items.get(i);
            Item item = new Item(s.get(0),s.get(1), s.get(2));
            itemsList.add(item);
        }
        if (sortOrder == 0) {
            if (sortParameter == 0) {
                Collections.sort(itemsList, new SortItemComp1());
            } else if (sortParameter == 1) {
                Collections.sort(itemsList, new SortItemComp2());
            } else if (sortParameter == 2){
                Collections.sort(itemsList, new SortItemComp3());
            }
        } else {
            if (sortParameter == 0) {
                Collections.sort(itemsList, new SortItemComp4());
            } else if (sortParameter == 1) {
                Collections.sort(itemsList, new SortItemComp5());
            } else if (sortParameter == 2){
                Collections.sort(itemsList, new SortItemComp6());
            }
        }

        int si = itemsPerPage*pageNumber;
        for (int i=si;i<si+itemsPerPage && i<items.size();i++) {
            String name = itemsList.get(i).a;
            ans.add(name);
        }
        return ans;
    }
}
