package com.example.demo.amazon;

public class LargestVariance {
    public static int largestVariance(String s) {
        int maxVariance=0;
        //two loops to get all the possible combinations of the character pair that exist
        for(int highFreq=0;highFreq<=26;highFreq++){
            for(int lowFreq=0;lowFreq<26;lowFreq++){
                //if both the characters are same no need to calculate as variance will be zero
                if(lowFreq == highFreq)
                    continue;
                int curLow=0,curHigh=0;
                boolean lowCharIgnored = false;
                for(char ch : s.toCharArray()){
                    //update the current freq as per current character
                    int freq = ch-'a';
                    if(freq == highFreq) curHigh++;
                    if(freq == lowFreq) curLow++;
                    //if both high and low freq exist then calculate the maxVariance as per
                    //kadane's algorithm
                    if(curLow > 0 && curHigh > 0)
                        maxVariance = Math.max(maxVariance,curHigh-curLow);
                    else{
                        //if you have ignored one of the low frequency you can always use one
                        //ignored occurence for corner cases
                        if(lowCharIgnored)
                            maxVariance = Math.max(maxVariance,curHigh-1);
                    }
                    //as we always want curHigh > curLow, if that's not the case simply reset
                    //the counters and lowCharIgnored to true as you are ignoring one of the low freq
                    if(curLow > curHigh){
                        curHigh = 0;
                        curLow = 0;
                        lowCharIgnored=true;
                    }
                }
            }
        }
        return maxVariance;
    }
    public static void main(String[] args) {
        System.out.println(largestVariance("aababbb"));
    }
}
