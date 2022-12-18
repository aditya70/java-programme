package com.example.demo.pr.lc;

import java.util.Arrays;
import java.util.Comparator;

class Interval {
    int start, end;
}

class ArrayComparator implements Comparator<Interval> {
    public int compare(Interval a, Interval b) {
        return a.end - b.end;
    }
}

public class NonOverlappingInterval {
    Interval[] interval;

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        interval=new Interval[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            interval[i] = new Interval();
            interval[i].start = intervals[i][0];
            interval[i].end = intervals[i][1];
        }
        Arrays.sort(interval, new ArrayComparator());
        int c=1, e=interval[0].end;
        for (int i=0;i<interval.length;i++) {
            if(interval[i].start>=e) {
                e=interval[i].end; c++;
            }
        }
        return interval.length-c;
    }

    public static void main(String[] args) {
        NonOverlappingInterval noi= new NonOverlappingInterval();
        int[][] t= new int[][]{{1,2},{2,3}};
        System.out.println(noi.eraseOverlapIntervals(t));
    }
}
