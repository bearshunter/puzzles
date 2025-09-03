package org.dpo.leetcode.arrays;

public class RemoveDuplicatesFromSortedArray {

    private static int removeDuplicates(int[] nums) {
        if(nums.length == 1){
            return 1;
        }

        int k = 1;

        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[k-1]){
                nums[k] = nums[i];
                k++;
            }

        }
        return k;
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


