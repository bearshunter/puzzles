package org.dpo.leetcode.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MajorityElements {

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        final int majorityElement = majorityElement(nums);
        System.out.println(majorityElement);
        final int majorityElementBest = majorityElementBest(nums);
        System.out.println(majorityElementBest);

    }

    public static int majorityElementBest(int[] nums) {
        int res = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count > nums.length / 2) {
                return res;
            }
            if (res == nums[i]) {
                count++;
            } else if (count == 0) {
                res = nums[i];
                count++;
            } else {
                count--;
            }

        }
        return res;
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

    public int majorityElementStreams(int[] nums) {
        return Arrays.stream(nums).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey();
    }
}
