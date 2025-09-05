package org.dpo.leetcode.string;

public class IsSubsequence {
    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc")); // true
        System.out.println(isSubsequence("axc", "ahbgdc")); // false
    }

    public static boolean isSubsequence(String s, String t) {
        int subp = 0;
        int textp = 0;

        while (subp < s.length() && textp < t.length()){
            if(t.charAt(textp) == s.charAt(subp)){
                subp++;
            }
            textp++;

        }
        return subp == s.length();
    }
}
