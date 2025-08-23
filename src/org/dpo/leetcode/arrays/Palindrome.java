package org.dpo.leetcode.arrays;

public class Palindrome {


    public static void main(String[] args) {
        System.out.println(isPalindrome(1234321));
    }

    public static boolean isPalindrome(int num) {
        if (num < 0 || (num % 10 == 0 && num != 0)) {
            return false;
        }

        int revHalf = 0;
        while (num > revHalf) {
            revHalf = revHalf * 10 + num % 10;
            num /= 10;
        }

        return num == revHalf || num == revHalf / 10;
    }

    private boolean isPalindromeChar(int num) {
        char[] array = String.valueOf(num).toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - i - 1) {
                return true;
            }
            if (array[i] == array[array.length - i - 1]) {
                continue;
            }
            return false;
        }
        return true;
    }

     private boolean isPalindromeJava(int x){
         String s = Integer.toString(x);
         return s.equals(new StringBuilder(s).reverse().toString());
     }

}
