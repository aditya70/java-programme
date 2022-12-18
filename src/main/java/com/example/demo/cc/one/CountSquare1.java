package com.example.demo.cc.one;

import java.awt.*;
import java.util.Queue;
import java.util.*;

/* Name of the class has to be "Main" only if the class is public. */
// control + option + O // remove unused imports intellij
// command + option + L // Indentation intellij
// https://math.stackexchange.com/questions/958381/how-to-find-the-number-of-squares-formed-by-given-lattice-points
class CountSquare1 {
    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            Set<Point> set = new HashSet<>();
            int n = sc.nextInt();
            for (int j = 0; j < n; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                Point p = new Point(x, y);
                set.add(p);
            }
            System.out.println(count(set));
        }
    }

    public static int count(Set<Point> set) {
        int c = 0;
        Queue<Point> q = new LinkedList<>(set);
        Point pivot = q.poll();
        Point a = new Point();
        Point b = new Point();
        while (!q.isEmpty()) {
            set.remove(pivot);
            for (Point point : q) {
                int dx = point.y - pivot.y;
                int dy = pivot.x - point.x;
                a.setLocation(pivot.x + dx, pivot.y + dy);
                b.setLocation(point.x + dx, point.y + dy);
                if (set.contains(a) && set.contains(b)) {
                    c++;
                }
            }
            pivot = q.poll();
        }
        return c;
    }
}