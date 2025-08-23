package org.dpo.leetcode.arrays;

public class ReverseString {

    public static void main(String[] args) {
        reverseString(new char[]{'a', 'b', 'c'});
    }


    public static void reverseString(char[] sArr) {
        for (int i = 0; i < sArr.length / 2; i++) {
            int oppositeI = sArr.length - i - 1;
            if (i != oppositeI) {
                char buff = sArr[i];
                sArr[i] = sArr[oppositeI];
                sArr[oppositeI] = buff;
            }
        }
    }
}
