package com.example.demo.archive.oa;

public class DRWTwo {

    public static int countShips(char [][] grid){
        int n=grid.length;
        int m=grid[0].length;
        int count3=0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                // if the cell is land cell, call dfs function and increment the count by 1
                if(i+1<n && j+1<m && grid[i][j]=='#' && grid[i+1][j]=='#' &&  grid[i][j+1]=='#') {
                    dfs(grid,i,j);
                    dfs(grid,i+1,j);
                    dfs(grid,i,j+1);
                    count3++;
                }
            }
        }

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                // if the cell is land cell, call dfs function and increment the count by 1
                if(i+1<n && j+1<m && grid[i][j]=='#' && grid[i][j+1]=='#' &&  grid[i+1][j+1]=='#') {
                    dfs(grid,i,j);
                    dfs(grid,i,j+1);
                    dfs(grid,i+1,j+1);
                    count3++;
                }
            }
        }

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                // if the cell is land cell, call dfs function and increment the count by 1
                if(i+1<n && j+1<m && j+2<m && grid[i][j]=='#' && grid[i][j+1]=='#' &&  grid[i][j+2]=='#') {
                    dfs(grid,i,j);
                    dfs(grid,i,j+1);
                    dfs(grid,i,j+2);
                    count3++;
                }
            }
        }

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                // if the cell is land cell, call dfs function and increment the count by 1
                if(i+1<n && j+1<m && i+2<n && grid[i][j]=='#' && grid[i+1][j]=='#' &&  grid[i+2][j]=='#') {
                    dfs(grid,i,j);
                    dfs(grid,i+1,j);
                    dfs(grid,i+2,j);
                    count3++;
                }
            }
        }

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                // if the cell is land cell, call dfs function and increment the count by 1
                if(i+1<n && j+1<m && grid[i][j]=='#' && grid[i+1][j]=='#' &&  grid[i+1][j+1]=='#') {
                    dfs(grid,i,j);
                    dfs(grid,i+1,j);
                    dfs(grid,i+1,j+1);
                    count3++;
                }
            }
        }

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                // if the cell is land cell, call dfs function and increment the count by 1
                if(i+1<n && j-1>=0 && i-1>=0  && grid[i][j]=='#' && grid[i+1][j]=='#' &&  grid[i-1][j-1]=='#') {
                    dfs(grid,i,j);
                    dfs(grid,i+1,j);
                    dfs(grid,i-1,j-1);
                    count3++;
                }
            }
        }
        int count2 = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                // if the cell is land cell, call dfs function and increment the count by 1
                if(i<n && j+1<m  && grid[i][j]=='#' && grid[i][j+1]=='#') {
                    dfs(grid,i,j);
                    dfs(grid,i,j+1);
                    count2++;
                }
            }
        }

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                // if the cell is land cell, call dfs function and increment the count by 1
                if(i+1<n && j<m  && grid[i][j]=='#' && grid[i+1][j]=='#') {
                    dfs(grid,i,j);
                    dfs(grid,i+1,j);
                    count2++;
                }
            }
        }
        int count1 =0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                // if the cell is land cell, call dfs function and increment the count by 1
                if(i+1<n && j<m  && grid[i][j]=='#') {
                    dfs(grid,i,j);
                    count1++;
                }
            }
        }
        System.out.println("c3: "+count3);
        System.out.println("c2: "+count2);
        System.out.println("c1: "+count1);
        return count3;
    }

    public static void dfs(char[][] grid, int i,int j){
        int n=grid.length;
        int m=grid[0].length;

        // base case
        // if i,j goes out of bound or it is not a land cell ,then return
        if(i<0 || j<0 || i>=n || j>=m || grid[i][j]!='#')
            return ;

        // marking this cell as visited by assigning 2
        grid[i][j]='.';

        // calling dfs for given valid directions
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
    public static void main(String[] args) {

    }
}
