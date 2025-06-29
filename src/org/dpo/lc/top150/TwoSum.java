package org.dpo.lc.top150;

import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int[] ints = twoSum(nums, 10);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            //1
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i]+ nums[j] == target) {
                    return new int[]{nums[i], nums[j]};
                }
            }
        }
        return new int[]{};
    }
}
