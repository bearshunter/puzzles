package org.dpo.leetcode.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicates {

    public static void main(String[] args) {
        containsDuplicateBestSpeed(new  int[]{1, 2, 3, 4, 5});
        containsDuplicateBestMemory(new  int[]{1, 2, 3, 4, 5});
    }

    public static boolean containsDuplicateBestSpeed(int[] nums) {
        if (nums.length == 1) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsDuplicateBestMemory(int[] nums) {
        if (nums.length < 2) return false;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) return true;
        }
        return false;
    }
}
