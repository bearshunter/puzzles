package org.dpo.leetcode.arrays;

import java.util.Arrays;

public class Exam {


//    Input: nums = [0,0,1,1,1,2,2,3,3,4]
//    Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,5,6};

        System.out.println( binarySearch(nums1,6));
        System.out.println(Arrays.toString(nums1));
    }

    public static  int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left == right) {
            int mid = left + (right - left) /2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] > target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        return -1;
    }



}
