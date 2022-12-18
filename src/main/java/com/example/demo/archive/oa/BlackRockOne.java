package com.example.demo.archive.oa;

import java.util.Stack;

public class BlackRockOne {

    public static void main(String[] args) {
        System.out.println("hello");
    }

    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
            for (int i=0; i<s.length(); i++){
                Character c=s.charAt(i);
                if (c== '(' || c== '{' || c== '[') st.push(c);
                else {
                    if (st.isEmpty()) return false;
                    Character p=st.pop();
                    if (c== ')' && p != '(') return false;
                    else if (c== '}' && p != '{') return false;
                    else if (c== ']' && p != '[') return false;
                }
            }
            if (!st.isEmpty()) return false;
            return true;
    }
}
