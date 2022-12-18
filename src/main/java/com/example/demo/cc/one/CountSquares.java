package com.example.demo.cc.one;

import java.io.* ;
import java.util.* ;

class CountSquares {
    final static long r = 1000000007;
    public static void main(String[] args) {
        FasterScanner input = new FasterScanner(System.in) ;
        PrintWriter output =  new PrintWriter(System.out) ;
        int test = input.nextInt() ;
        for(int i=0 ; i<test ; i++){
            int length = input.nextInt() ;
            int[][] coar = new int[length][2] ;
            for(int j=0 ; j<length ; j++){
                coar[j][0]=input.nextInt() ;
                coar[j][1]=input.nextInt() ;
                coar[j][0]+=50 ;
                coar[j][1]+=50 ;
            }
            output.println(CoutSquares(coar)) ;
        }
        output.flush() ;
        output.close() ;
    }

    static long CoutSquares(int [][] coar){
        int [][] Cordi = new int[101][101] ;
        for(int i=0 ; i<101 ; i++){
            for(int j=0 ; j<101 ; j++){
                Cordi[i][j]=0 ;
            }
        }
        for(int i=0 ; i<coar.length ; i++){
            ++Cordi[coar[i][0]][coar[i][1]] ;
        }
        int count=0  ;
        for(int i=0 ; i<coar.length-1 ; i++ ){
            for(int j=i+1 ; j<coar.length ; j++){
                int a,b,c,d ;
                a = coar[i][0]+coar[i][1] ;
                b = coar[j][0]+coar[j][1] ;
                c = coar[i][0]-coar[i][1] ;
                d = coar[j][0]-coar[j][1] ;
                if((a+d)%2==0 && (b+c)%2==0){
                    if(b+c>=0 && (b-c)>=0 && (a+d)>=0 && (a-d)>=0){
                        if(b+c<=200 && (b-c)<=200 && (a+d)<=200 && (a-d)<=200){
                            if(Cordi[(b+c)/2][(a-d)/2]==1 && Cordi[(a+d)/2][(b-c)/2]==1)
                                count++ ;}}
                }
            }
        }
        count = count/2 ;
        return count ;
    }

    static long ModInverse(long a ){
        return FastPow(a,r-2) ;

    }
    static long FastPow(long a , long b){
        if(b==0)
            return 1 ;
        if(b==1)
            return a ;
        long halfpow = FastPow(a,b/2) ;
        if(b%2==0)
            return (halfpow*halfpow)%r ;
        else
            return (((halfpow*halfpow)%r)*a)%r ;
    }
}

class FasterScanner {
    private InputStream mIs;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    public FasterScanner() {
        this(System.in);
    }
    public FasterScanner(InputStream is) {
        mIs = is;
    }
    public int read() {
        if (numChars == -1) {
            throw new InputMismatchException();
        }
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = mIs.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0) {
                return -1;
            }
        }
        return buf[curChar++];
    }
    public String nextLine() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isEndOfLine(c));
        return res.toString();
    }

    public String nextString() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }

    public long nextLong() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        long res = 0;
        do {
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public int nextInt() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    public boolean isEndOfLine(int c) {
        return c == '\n' || c == '\r' || c == -1;
    }
}
