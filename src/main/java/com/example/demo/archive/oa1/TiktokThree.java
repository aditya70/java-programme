
package com.example.demo.archive.oa1;

import java.util.*;


// Similar to graph connected component
public class TiktokThree {
    static ArrayList<ArrayList<Integer>> adjList;
    static int V = 100000;

    static class Count {
        public int c;
    }

    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int l=0;l<t;l++){
            adjList = new ArrayList<>();;
            for (int i = 0; i < V; i++) {
                adjList.add(i, new ArrayList<>());
            }
            int m = in.nextInt();
            for(int j=0;j<m;j++){
                int x = in.nextInt();
                int y = in.nextInt();
                adjList.get(x).add(y);
                adjList.get(y).add(x);
            }
            int ans = socialNetworks();
            System.out.println(ans);
        }
    }
    static void DFS(int v, boolean[] visited, Count c) {
        c.c++;
        visited[v] = true;
        for (int x : adjList.get(v)) {
            if (!visited[x])
                DFS(x, visited, c);
        }
    }

    static int socialNetworks() {
        int ans = 0;
        boolean[] visited = new boolean[V];
        for (int v = 0; v < TiktokThree.V; ++v) {
            if (!visited[v]) {
                Count c = new Count();
                DFS(v, visited, c);
                ans = Math.max(ans, c.c);

            }
        }
        return ans;
    }
}