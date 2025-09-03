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

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        final Map<Character, Integer> romanToIntMap = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000);
        int result = 0;
        for (char c : s.toCharArray()) {
            if (romanToIntMap.containsKey(c)) {

                result += romanToIntMap.get(c);
            } else {
                throw new IllegalArgumentException("Invalid Roman numeral: " + c);
            }
        }
        return result;
    }
}
