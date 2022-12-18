package com.example.demo.archive.oa;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class DRWSol {
    public int[] solution(String[] B) {
        // write your code in Java SE 8
        int[] r = new int[3];
        int m = B.length, n = B[0].length();
        char[][] board = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = B[i].charAt(j);
            }
        }
        return countBattleShips(board);
    }

    public int[] countBattleShips(char[][] board) {
        int[] r = new int[3];
        int n = board.length;
        int m = board[0].length;
        int count3 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i + 1 < n && j + 1 < m && board[i][j] == '#' && board[i + 1][j] == '#' && board[i][j + 1] == '#') {
                    dfs(board, i, j);
                    dfs(board, i + 1, j);
                    dfs(board, i, j + 1);
                    count3++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i + 1 < n && j + 1 < m && board[i][j] == '#' && board[i][j + 1] == '#' && board[i + 1][j + 1] == '#') {
                    dfs(board, i, j);
                    dfs(board, i, j + 1);
                    dfs(board, i + 1, j + 1);
                    count3++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i + 1 < n && j + 1 < m && j + 2 < m && board[i][j] == '#' && board[i][j + 1] == '#' && board[i][j + 2] == '#') {
                    dfs(board, i, j);
                    dfs(board, i, j + 1);
                    dfs(board, i, j + 2);
                    count3++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i + 1 < n && j + 1 < m && i + 2 < n && board[i][j] == '#' && board[i + 1][j] == '#' && board[i + 2][j] == '#') {
                    dfs(board, i, j);
                    dfs(board, i + 1, j);
                    dfs(board, i + 2, j);
                    count3++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i + 1 < n && j + 1 < m && board[i][j] == '#' && board[i + 1][j] == '#' && board[i + 1][j + 1] == '#') {
                    dfs(board, i, j);
                    dfs(board, i + 1, j);
                    dfs(board, i + 1, j + 1);
                    count3++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i + 1 < n && j - 1 >= 0 && board[i][j] == '#' && board[i + 1][j] == '#' && board[i + 1][j - 1] == '#') {
                    dfs(board, i, j);
                    dfs(board, i + 1, j);
                    dfs(board, i + 1, j - 1);
                    count3++;
                }
            }
        }
        int count2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i < n && j + 1 < m && board[i][j] == '#' && board[i][j + 1] == '#') {
                    dfs(board, i, j);
                    dfs(board, i, j + 1);
                    count2++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i + 1 < n && j < m && board[i][j] == '#' && board[i + 1][j] == '#') {
                    dfs(board, i, j);
                    dfs(board, i + 1, j);
                    count2++;
                }
            }
        }
        int count1 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i < n && j < m && board[i][j] == '#') {
                    dfs(board, i, j);
                    count1++;
                }
            }
        }
        r[0] = count1;
        r[1] = count2;
        r[2] = count3;
        return r;
    }

    public static void dfs(char[][] board, int i, int j) {
        int n = board.length;
        int m = board[0].length;
        if (i < 0 || j < 0 || i >= n || j >= m || board[i][j] != '#')
            return;
        board[i][j] = '.';
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }
}

