package com.example.demo.archive.oa;

import java.util.HashMap;
import java.util.Map;

public class TestSIG1 {
//    boolean solution(int[][] grid) {
//        for (int i = 0; i < 9; i++) {
//            int[] c = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
//            int[] r = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
//            int[] b = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
//            for (int j = 0; j < 9; j++) {
//                int bc = grid[(i / 3) * 3 + j / 3][(i % 3) * 3 + j % 3];
//                int rc = grid[i][j];
//                int cc = grid[j][i];
//                b[bc] += 1;
//                r[rc] += 1;
//                c[cc] += 1;
//            }
//            for (int j = 0; j <= 9; j++) {
//                boolean valid = isValid(b[j]) && isValid(r[j]) && isValid(c[j]);
//                if (!valid)
//                    return false;
//            }
//        }
//        return true;
//    }
//
//    private boolean isValid(int count) {
//        return count == 0 || count == 1;
//    }

    public int get(HashMap<Integer, Integer> hm, int k) {
        return hm.get(k);
    }
    public void insert(HashMap<Integer, Integer> hm, int k, int v) {
        hm.put(k,v);
    }
    public void addToValue(HashMap<Integer, Integer> hm, int v) {
        for (Map.Entry<Integer, Integer> e: hm.entrySet()) {
            int ke = e.getKey();
            int va = e.getValue();
            hm.remove(ke);
            hm.put(ke, va + v);
        }
    }
    public void addToKey(HashMap<Integer, Integer> hm, int k) {
        for (Map.Entry<Integer, Integer> e: hm.entrySet()) {
            int ke = e.getKey();
            int va = e.getValue();
            hm.remove(ke);
            hm.put(ke + k, va);
        }
    }
    long solution(String[] queryType, int[][] query) {
        long res = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i< queryType.length;i++) {
            String type =  queryType[i];
            int[] q = query[i];
            switch (type) {
                case "get" :
                    res += get(hm,q[0]);
                    break;
                case "insert" :
                    insert(hm, q[0], q[1]);
                    break;
                case "addToKey" :
                    addToKey(hm, q[0]);
                    break;
                case "addToValue" :
                    addToValue(hm, q[0]);
                    break;
                default:
                    break;

            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
