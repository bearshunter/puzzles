package org.dpo.leetcode.string;

public class LengthOfLastWord {

    public static void main(String[] args) {
        String s = "Hello World";
        final int length = lengthOfLastWord(s);
        System.out.println(length); // Output: 5
    }

    public static int lengthOfLastWord(String s) {
        int lastWordLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(s.length() - 1 - i) == ' ' && lastWordLength > 0) {
                break;
            }
            if (s.charAt(s.length() - 1 - i) != ' ') {
                lastWordLength++;
            }
        }

        return lastWordLength;
    }
}
