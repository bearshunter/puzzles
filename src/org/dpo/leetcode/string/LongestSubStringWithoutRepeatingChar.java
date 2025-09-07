package org.dpo.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepeatingChar {

    public static void main(String[] args) {
        String s1 = "abcabcbb"; // Output: 3
        String s2 = "bbbbb";    // Output: 1
        String s3 = "pwwkew";   // Output: 3
        String s4 = "";         // Output: 0
        System.out.println(lengthOfLongestSubstring(s1));
    }


    public static int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        char[] arr = s.toCharArray();
        int res = 0;
        int rp = 0;
        Map<Character, Integer> visited = new HashMap<>();
        while (rp < arr.length) {
            if (visited.containsKey(arr[rp])) {
                res = Math.max(res, visited.size());
                rp = visited.getOrDefault(arr[rp], rp);
                visited.clear();
            } else {
                visited.put(arr[rp],rp);
            }
            rp++;
        }

        return Math.max(res, visited.size());

    }
}
