package com.example.demo.archive.oa;

public class IMC1 {
    public static void main(String[] args) {
        String ans = solution(1, 1, 4, 7, 6);
        System.out.println(ans);
    }

    public static String solution(int c, int x1, int y1, int x2, int y2) {
        if (x1 + c == x2 && y1 + c == y2) return "No";
        int k = Math.max(Math.max(x1, y1), Math.max(x2, y2));
        int[][] d = new int[k + 1][k + 1];
        d[x1][y1] = 1;
        for (int i = x1; i < k + 1; i++) {
            for (int j = y1; j < k + 1; j++) {
                if (isPerfectSquare(i + j) || (i == x1 && j == y1)) continue;
                else if ((i - c) > -1 && (j - c) > -1 && d[i - c][j - c] == 1) d[i][j] = 1;
                else if ((i - j >= 0 && d[i - j][j] == 1) || (j - i >= 0 && d[i][j - i] == 1)) d[i][j] = 1;
            }
        }
        if (d[x2][y2] == 1) return "Yes";
        else return "No";
    }

    public static boolean isPerfectSquare(int x) {
        if (x >= 0) {
            int sr = (int) Math.sqrt(x);
            return (sr * sr) == x;
        } else return false;
    }
}
