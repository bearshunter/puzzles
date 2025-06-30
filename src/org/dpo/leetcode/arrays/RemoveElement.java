package org.dpo.leetcode.arrays;

import java.util.Arrays;

public class RemoveElement {

    public static void main(String[] args) {
        int[] ints = {0, 1, 2, 2, 3, 0, 4, 2};
        int res = removeElement(ints, 2);
        System.out.println(res);
        System.out.println(Arrays.toString(ints));
    }

    private static int removeElement(int[] nums, int val) {
        int pointer = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[pointer] = nums[i];
                pointer++;
            }
        }
        return pointer;
    }
}
