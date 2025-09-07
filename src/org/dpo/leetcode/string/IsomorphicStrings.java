package org.dpo.leetcode.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public static void main(String[] args) {
        String s = "paper";
        String t = "title";
        boolean res = isIsomorphic(s, t);
        System.out.println(res);
    }


    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> st = new HashMap<>();
        Map<Character, Character> ts = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            if (st.containsKey(sc) && st.get(sc) != tc) {
                return false;
            }
            if (ts.containsKey(tc) && ts.get(tc) != sc) {
                return false;
            }

            st.put(sc, tc);
            ts.put(tc, sc);
        }

        return true;
    }

}


