package org.dpo.leetcode.string;

import java.util.HashMap;

public class WordPattern {

    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog cat cat dog";
        WordPattern wp = new WordPattern();
        boolean res = wp.wordPattern(pattern, s);
        System.out.println(res);
    }
    public boolean wordPattern(String pattern, String s) {
        String[] sArr = s.split(" ");
        if (sArr.length != pattern.length()) {
            return false;
        }
        char[] patternArr = pattern.toCharArray();
        var psmap = new HashMap<>();
        var spmap = new HashMap<>();

        for (int i = 0; i < sArr.length; i++) {
            if (psmap.containsKey(patternArr[i]) && !psmap.get(patternArr[i]).equals(sArr[i])) {
                return false;
            }

            if (spmap.containsKey(sArr[i]) && !spmap.get(sArr[i]).equals(patternArr[i])) {
                return false;
            }

            psmap.put(patternArr[i], sArr[i]);
            spmap.put(sArr[i], patternArr[i]);

        }

        return true;

    }
}
