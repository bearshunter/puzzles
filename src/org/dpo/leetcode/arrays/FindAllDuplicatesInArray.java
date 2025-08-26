package org.dpo.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllDuplicatesInArray {

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> duplicates = findDuplicates(nums);
        System.out.println(Arrays.toString(duplicates.toArray()));
    }


    public static List<Integer> findDuplicates(int[] nums) {
        final List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            int numAbs = (num < 0) ? -num : num;
            if (nums[numAbs - 1] < 0) {
                res.add(numAbs);
            } else {
                nums[numAbs - 1] = -nums[numAbs - 1];
            }
        }
        return res;

    }
}
