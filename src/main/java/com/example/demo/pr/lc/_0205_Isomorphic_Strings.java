package com.example.demo.pr.lc;

import java.util.HashMap;

public class _0205_Isomorphic_Strings {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> hm = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            if (hm.containsKey(s.charAt(i))) {
                char c = hm.get(s.charAt(i));
                if (c != t.charAt(i))
                    return false;
            }
            else if (!hm.containsValue(t.charAt(i))) {
                hm.put(s.charAt(i),t.charAt(i));
            }
            else {
                return false;
            }
        }
        return true;
    }
}
