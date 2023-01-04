package com.example.demo.pr.lc;

import java.util.Stack;

public class _020_Valid_Parentheses {

    public static boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            Character c=s.charAt(i);
            if(c=='(' || c=='{' || c=='[') st.push(c);
            else{
                if (st.size()==0) return false;
                else {
                    Character p=st.pop();
                    if((c==')' && p!='(') || (c=='}' && p!='{') || (c==']' && p!='[')) return false;
                }
            }
        }
        if (!st.isEmpty()) return false;
        return true;
    }
    public static void main(String[] args) {
        String s="(}";
        isValid(s);
    }
}
