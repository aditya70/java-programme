package com.example.demo.archive.oa;

public class IMC11 {

    public static boolean reachingPoints(int x1, int y1, int x2, int y2) {

        while (x1 < x2 && y1 < y2)
            if (x2 < y2)
                y2 %= x2;
            else
                x2 %= y2;

        if (x1 == x2 && y1 <= y2 && (y2 - y1) % x1 == 0)
            return true;

        return y1 == y2 && x1 <= x2 && (x2 - x1) % y1 == 0;
    }

    public static boolean reachingPoints1(int x1, int y1, int x2, int y2) {
        while (x1 < x2 && y1 < y2)
            if (x2 < y2) y2 %= x2;
            else x2 %= y2;
        return x1 == x2 && y1 <= y2 && (y2 - y1) % x1 == 0 ||
                y1 == y2 && x1 <= x2 && (x2 - x1) % y1 == 0;
    }


}
