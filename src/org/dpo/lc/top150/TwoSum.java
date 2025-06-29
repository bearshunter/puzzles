package org.dpo.lc.top150;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int[] ints = twoSumWithHash(nums, 6);
        System.out.println(Arrays.toString(ints));
    }

    private static int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            //1
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{nums[i], nums[j]};
                }
            }
        }
        return new int[]{};
    }

    private static int[] twoSumWithHash(int[] nums, int target) {
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hash.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (hash.containsKey(complement)) {
                if (i != hash.get(complement)) {
                    return new int[]{i, hash.get(complement)};
                }
            }

        }
        return new int[]{};
    }

    private static int[] twoSumWithHashBest(int[] nums, int target) {
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (hash.containsKey(complement)) {
                return new int[]{hash.get(complement), i};
            }
            hash.put(nums[i], i);
        }
        return new int[]{};
    }
}
