package org.dpo.hrr.easy;

public class FormatOutput {

    public static void main(String[] args) {
        int[] numbers = new int[]{11, 333, 4};
        String[] words = new String[]{"aaa", "bbb", "cc"};
        for (int i = 0; i < 3; i++) {
            String s1 = words[i];
            int x = numbers[i];
            String padded = String.format("%-15s", s1);
            String formattedNumber = String.format("%03d", x);
            System.out.println(padded + formattedNumber);
        }
        System.out.println("================================");

    }
}
