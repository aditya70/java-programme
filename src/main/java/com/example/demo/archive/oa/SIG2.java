package com.example.demo.archive.oa;

public class SIG2 {
        boolean solution(int[][] grid) {
        for (int i = 0; i < 9; i++) {
            int[] c = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            int[] r = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            int[] b = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            for (int j = 0; j < 9; j++) {
                int bc = grid[(i / 3) * 3 + j / 3][(i % 3) * 3 + j % 3];
                int rc = grid[i][j];
                int cc = grid[j][i];
                b[bc] += 1;
                r[rc] += 1;
                c[cc] += 1;
            }
            for (int j = 0; j <= 9; j++) {
                boolean valid = isValid(b[j]) && isValid(r[j]) && isValid(c[j]);
                if (!valid)
                    return false;
            }
        }
        return true;
    }

    private boolean isValid(int count) {
        return count == 0 || count == 1;
    }
}
