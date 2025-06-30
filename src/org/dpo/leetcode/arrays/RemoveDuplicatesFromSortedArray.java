package org.dpo.leetcode.arrays;

public class RemoveDuplicatesFromSortedArray {

    private static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int writeIndex = 1;
        for (int readIndex = 1; readIndex < nums.length; readIndex++) {
            if (nums[readIndex] != nums[writeIndex - 1]) {
                nums[writeIndex] = nums[readIndex];
                writeIndex++;
            }
        }
        System.out.println(nums);
        return writeIndex;
    }


    public static void main(String[] args) {

        int[] nums1 = {1, 1, 2};

        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        int[] nums3 = {};

        int[] nums4 = {1};

        removeDuplicates(nums1);
        removeDuplicates(nums2);
        removeDuplicates(nums3);
        removeDuplicates(nums4);


    }
}


