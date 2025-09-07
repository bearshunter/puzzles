package org.dpo.leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringIsAnagram {
    public static void main(String[] args) {
        if (isAnagramWithMemory("aba", "bna"))
            System.out.println("true");
        else
            System.out.println("false");
    }


    public static boolean isAnagramSort(String s, String t) {
        if (s.length() != t.length())
            return false;
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        return Arrays.equals(sArray, tArray);
    }

    public static boolean isAnagramWithMemory(String s, String t) {
        if (s.length() != t.length())
            return false;
        Map<Character, Long> sMap = s.chars()
                .mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        Map<Character, Long> tMap = t.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        if (sMap.size() != tMap.size()) {
            return false;
        }
        for (Map.Entry<Character, Long> entry : sMap.entrySet()) {
            Character key = entry.getKey();
            long value = entry.getValue();

            if (!tMap.containsKey(key)) {
                return false;
            }

            long tValue = tMap.get(key);
            if (value != tValue) {
                return false;
            }
        }

        return true;
    }


    public boolean isAnagramOnlyLetters(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26]; //[0,0,0,....]
        var sArr = s.toCharArray();
        var tArr = t.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            count[sArr[i] - 'a']++;//[1,0,0]
            count[tArr[i] - 'a']--;//[-1,0,0]
        }

        for (int c : count) {
            if (c != 0) {
                return false;
            }

        }
        return true;

    }
}
