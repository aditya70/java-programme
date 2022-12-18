package com.example.demo.archive.oa;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class DRWOne {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int ans=0, n=A.length;
        for (int i=0;i<n-1;i++) {
            for (int j=i+1;j<n;j++) {
                if (increasing(A,i,j) || decreasing(A,i,j) || equalNum(A, i, j)) {
                    ans++;
                    if (ans > 1000000000) return -1;
                }
            }
        }

        return ans;
    }
    public boolean increasing(int[] A, int s, int e) {
        for (int i = s; i < e ; ++i) {
            if (A[i] >= A[i+1]) {
                return false;
            }
        }
        return true;
    }

    public boolean decreasing(int[] A, int s, int e) {
        for (int i = s; i < e ; ++i)
            if (A[i] <= A[i+1]) {
                return false;
            }
        return true;
    }

    public boolean equalNum(int[] A, int s, int e) {
        for (int i = s; i < e; ++i)
            if (A[i] != A[i+1]) return false;
        return true;
    }
}

