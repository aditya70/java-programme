package com.example.demo.archive.oa;

import java.util.*;

class Pair15 {
    public String des;
    public double weight;

    public Pair15(String des, double weight) {
        this.des = des;
        this.weight = weight;
    }
}

class Exchange {
    public String src;
    public String des;
    public double weight;

    public Exchange(String src, String des, double weight) {
        this.src = src;
        this.des = des;
        this.weight = weight;
    }
}

class Rate {
    public double rate;

    public Rate(double rate) {
        this.rate = rate;
    }
}

public class CurrencyExchange {
    private Map<String, ArrayList<Pair15> > adj = new HashMap<>();
    private HashSet<String> visited = new HashSet<>();

    void addEdge(String src, String des, double weight)
    {
        ArrayList<Pair15> l = adj.get(src);;

        if (l == null) {
            l = new ArrayList<>();
            l.add(new Pair15(des, weight));
        } else {
            Pair15 p = new Pair15(des, weight);
            l.add(p);
        }
//        System.out.println(src + " " + des + " "+weight);
        adj.put(src,l);
//        addEdge(des, src, (double) (1.0/weight));
    }

    void dfs(String src, String des, double exc, Rate rate) {
        if (!adj.containsKey(src) || !adj.containsKey(des)) return;
        if (src.equals(des)) {
            rate.rate = Math.max(rate.rate, exc);
            return;
        }
        visited.add(src);
        for (Pair15 p : adj.get(src)) {
            if (!visited.contains(p.des)) dfs(p.des, des, exc*p.weight,rate);
        }

    }

    public double maxAmount(Exchange[] exchanges, String from_curr, String to_curr){
        Rate rate = new Rate(-1.0f);
        for (Exchange exchange: exchanges) {
            addEdge(exchange.src, exchange.des, exchange.weight);
            addEdge(exchange.des, exchange.src, (double) (1.0/exchange.weight));
        }
//        for (String s : adj.keySet()) {
//            ArrayList<Pair15> ap = adj.get(s);
//            for (Pair15 p: ap) {
//                System.out.println(s + "  "+p.des +" "+p.weight);
//            }
//            System.out.println();
//        }
        dfs(from_curr, to_curr, 1.0f, rate);
        return rate.rate;
    }

    // Driver's Code
    public static void main(String args[])
    {
        CurrencyExchange g = new CurrencyExchange();
        g.adj.clear();
        g.visited.clear();
        Exchange[] ex = new Exchange[4];
        Exchange ex1 = new Exchange("USD","CAD",1.3f);
        Exchange ex2 = new Exchange("USD","GBP",0.71f);
        Exchange ex3 = new Exchange("USD","JPY",109f);
        Exchange ex4 = new Exchange("GBP","JPY",155f);

//        Exchange ex1 = new Exchange("USD","GBP",0.7f);
//        Exchange ex2 = new Exchange("USD","JPY",109f);
//        Exchange ex3 = new Exchange("GBP","JPY",155f);
//        Exchange ex4 = new Exchange("CAD","CNY",5.27f);
//        Exchange ex5 = new Exchange("CAD","KRW",921f);

        ex[0]=ex1;
        ex[1]=ex2;
        ex[2]=ex3;
        ex[3]=ex4;
//        ex[4]=ex5;

        double ans = g.maxAmount(ex, "USD","JPY");

//        System.out.println("ans "+ans);
        double roundOff = Math.round(ans*100.0)/100.0;
        String.format("%.3f", roundOff); //%.3f defines decimal precision you want
        System.out.println(roundOff);
    }
}
