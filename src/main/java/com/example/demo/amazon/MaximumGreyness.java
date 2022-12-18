package com.example.demo.amazon;

public class MaximumGreyness {
    public static int maxGreyness(int[][] mat, int m, int n){
        int ans=0;
        int[] r= new int[m];
        int[] c=new int[n];
        for (int i=0;i<m;i++){
            int x=0;
            for (int j=0;j<n;j++){
                if(mat[i][j]==1) x++;
            }
            r[i]=x;
        }
        for (int i=0;i<n;i++){
            int y=0;
            for (int j=0;j<m;j++){
                if(mat[j][i]==1) y++;
            }
            c[i]=y;
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans=Math.max(ans,2*(r[i]+c[j])-(m+n));
            }
        }
        return ans;
    }
    public static void main(String[] args) {
//        int ans=maxGreyness();
    }
}
