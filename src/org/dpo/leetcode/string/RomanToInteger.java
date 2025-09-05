package org.dpo.leetcode.string;

import java.util.Map;

public class RomanToInteger {

    //Symbol       Value
    //I             1
    //V             5
    //X             10
    //L             50
    //C             100
    //D             500
    //M             1000

    private static final Map<Character, Integer> map = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000);

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        char[] arr = s.toCharArray();
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            int curr = map.get(arr[i]);
            int nextVal = i + 1 < arr.length ? map.get(arr[i + 1]) : 0;
            if (curr < nextVal) {
                res = res - curr;
            } else {
                res = res + curr;
            }
        }

        return res;

    }
}
