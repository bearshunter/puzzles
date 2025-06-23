package org.dpo.lc.top150;

import java.util.Arrays;

public class ArrayHasDuplicates {

    public static void main(String[] args) {
        boolean containsDuplicate = containsDuplicate(new int[]{11, 1, 1, 11});
        System.out.println(containsDuplicate);
    }

    public static boolean containsDuplicate(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        for (int i = 0; i < nums.length; i++) {

        }

        return false;
    }
}
