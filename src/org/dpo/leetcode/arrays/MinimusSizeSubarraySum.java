package org.dpo.leetcode.arrays;

public class MinimusSizeSubarraySum {
    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2,3,1,2,4,3};
        int res = minSubArrayLen(target, nums);
        System.out.println(res);
    }
    public static int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] >= target) {
                return 1;
            }

            sum = sum + nums[right];
            
            while (sum >= target){
                res =  Math.min(res, right - left + 1);
                sum = sum - nums[left];
                left++;
            }

        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
