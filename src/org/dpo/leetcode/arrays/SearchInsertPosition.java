package org.dpo.leetcode.arrays;


/*
 *    https://leetcode.com/problems/search-insert-position/
 */

public class SearchInsertPosition {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 4;
        int res = searchInsert(nums, target);
        System.out.println(res);

    }

    public static int searchInsert(int[] nums, int target) {
        int startIndex = 0;
        int endIndex = nums.length - 1;

        while (startIndex <= endIndex) {
            int mid = startIndex + (endIndex - startIndex) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                endIndex = mid - 1;
            } else {
                startIndex = mid + 1;
            }
        }
        return startIndex;
    }
}
