package org.dpo.leetcode.string;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        //String[] strs = {"flower", "flow", "flight"};
        String[] strs = {"flower","flower","flower","flower"};
        String result = longestCommonPrefix(strs);
        System.out.println(result); // Output: "fl"
    }

    public static String longestCommonPrefix(String[] words) {
        if (words == null || words.length == 0 || words[0].isEmpty()) {
            return "";
        }
        if (words.length == 1) {
            return words[0];
        }

        String result = "";
        boolean allMatch = true;
        while (allMatch) {
            if(words[0].length() < result.length() +1) {
                allMatch = false;
                break;
            }
            String prefix = words[0].substring(0, result.length() + 1);
            for (final String str : words) {
                if(str.length() < prefix.length()) {
                    allMatch = false;
                    break;
                }
                final char character = str.charAt(prefix.length() - 1);
                if (character != prefix.charAt(prefix.length() - 1)) {
                    allMatch = false;
                    break;
                }
            }

            if (allMatch) {
                result = prefix;
            }
        }


        return result;
    }

}
