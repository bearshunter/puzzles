package org.dpo.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MajorityElements {

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        final int majorityElement = majorityElement(nums);
        System.out.println(majorityElement);
    }

    public static int majorityElement(int[] nums) {
        if (nums.length == 2) {
            return nums[0];
        }
        final Map<Integer, Integer> numsInMap = new HashMap<>();
        for (int num : nums) {
            numsInMap.put(num, numsInMap.getOrDefault(num, 0) + 1);
        }


        final Set<Integer> keys = numsInMap.keySet();
        int result = 0;
        int maxCount = 0;
        for (int key : keys) {
            final Integer currentElement = numsInMap.get(key);
            if (currentElement > maxCount) {
                result = key;
                maxCount = currentElement;
            }
        }

        return result;
    }
}
