package org.dpo.leetcode.arrays;

import java.util.Arrays;

public class RotateArray {

//    Input: nums = [1,2,3,4,5,6,7], k = 3
//    Output: [5,6,7,1,2,3,4]
//    Explanation:
//    rotate 1 steps to the right: [7,1,2,3,4,5,6]
//    rotate 2 steps to the right: [6,7,1,2,3,4,5]
//    rotate 3 steps to the right: [5,6,7,1,2,3,4]


    public static void main(String[] args) {
        rotateSlow(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
        rotateUsingReverse(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
        rotateUsingReverse(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);

    }

    public static void rotateSlow(int[] nums, int k) {
        for (int j = 0; j < k; j++) {
            int buffer = nums[0];
            for (int i = 0; i < nums.length; i++) {
                int next = i + 1 == nums.length ? 0 : i + 1;
                int nextVal = nums[next];
                nums[next] = buffer;
                buffer = nextVal;
            }
        }

        System.out.println(Arrays.toString(nums));

    }

    public static void rotateUsingMemory(int[] nums, int k) {
        int realK;
        if(k > nums.length){
            realK = k % nums.length;
        } else {
            realK = k;
        }

        if (nums.length == 1 || realK == 0) {
            return;
        }
        int[] copy = Arrays.copyOf(nums, nums.length);
        for (int i = 0; i < nums.length; i++) {
            int next = getNext(nums, realK, i);
            nums[next] = copy[i];
        }
        System.out.println(Arrays.toString(nums));
    }

    private static int getNext(int[] nums, int k, int i) {
        if (i + k >= nums.length){
            return i + k - nums.length;
        }
        return i + k;
    }


    public static void rotateUsingReverse(int[] nums, int k) {
        if (nums == null || nums.length <= 1 || k == 0) {
            return;
        }

        // Normalize k to handle cases where k > nums.length
        k = k % nums.length;
        System.out.println(Arrays.toString(nums));
        // Step 1: Reverse the entire array
        reverse(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        // Step 2: Reverse the first k elements
        reverse(nums, 0, k - 1);
        System.out.println(Arrays.toString(nums));
        // Step 3: Reverse the remaining elements
        reverse(nums, k, nums.length - 1);
        System.out.println(Arrays.toString(nums));

    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            // Swap elements at start and end
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
