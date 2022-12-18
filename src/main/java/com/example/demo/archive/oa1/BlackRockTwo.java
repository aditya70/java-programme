package com.example.demo.archive.oa1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * The Main class implements an application that reads lines from the standard input
 * and prints them to the standard output.
 */
public class BlackRockTwo {
    /**
     * Iterate through each line of input.
     */


    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Weighted Directed Graph
        Map<String, Map<String, Double>> weightedDirectedGraph = new HashMap<>(); // key -> 'start' in the equations && value -> 'end' in equations mapped with the value
        int valueIdx = 0;

        // create the weighted directed graph
        for(List<String> equation : equations) {
            String start = equation.get(0);
            String end = equation.get(1);
            double weight = values[valueIdx++];

            weightedDirectedGraph.putIfAbsent(start, new HashMap<>()); // staraight connection
            weightedDirectedGraph.get(start).put(end, weight);

            weightedDirectedGraph.putIfAbsent(end, new HashMap<>()); // also do reverse connection
            weightedDirectedGraph.get(end).put(start, 1.0/weight);
        }

        double[] res = new double[queries.size()]; // to be returned, must of queries size
        int resIdx = 0;
        for(List<String> query : queries) { // we need to do this for every query
            String start = query.get(0);
            String end = query.get(1);

            if(!weightedDirectedGraph.containsKey(start) || !weightedDirectedGraph.containsKey(end)) { // if either start or end is not present in map, we cannot reach the answer
                res[resIdx++] = -1.0;
                continue;
            }

            res[resIdx++] = dfs(weightedDirectedGraph, start, end, new HashSet<>());
        }

        return res;
    }

    private static double dfs(Map<String, Map<String, Double>> weightedDirectedGraph, String start, String end, HashSet<String> visited) {
        if(weightedDirectedGraph.get(start).containsKey(end)) { // if the start's map of connections has the end we are looking for, we have got the result so return
            return weightedDirectedGraph.get(start).get(end);
        }

        visited.add(start); // to avoid cyclic dependency

        for(Map.Entry<String, Double> entry : weightedDirectedGraph.get(start).entrySet()) { // read all the entries of the map of 'start'
            if(visited.contains(entry.getKey())) continue;
            double res = dfs(weightedDirectedGraph, entry.getKey(), end, visited); // dfs on new key using this key as the start (still looking for end)
            if(res == -1.0) continue;

            return res * entry.getValue(); // if a/b = 2.0 and b/c = 3.0 then a/c = 2.0 * 3.0 = 6.0
        }

        return -1.0;
    }


    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        //double[] values = {110.0, 1.45, 0.0070};
        List<List<String>> equations = new ArrayList<>();
        List<List<String>> queries = new ArrayList<>();
        while ((line = in.readLine()) != null) {
            //   System.out.println(line);
            String [] split = line.split(";");
            double[] values =null;
            if(split.length>1){
                values = new double[split.length];
                for(int i=0;i<split.length;i++){
                    String [] split2 = split[i].split(",");
                    for(int j=0;j<split2.length;j++){
                        System.out.println(split2[j]);
                    }
                    List<String> eq1 = new ArrayList<>(Arrays. asList(split2[0], split2[1]));
                    values[i]=Double.valueOf(split[2]);
                    equations.add(eq1);
                }
            }else{
                List<String> q1 = new ArrayList<>();
                q1.add(split[0]);
                queries.add(q1);
            }

            System.out.println(calcEquation(equations, values, queries)[0]);
        }
    }
}
