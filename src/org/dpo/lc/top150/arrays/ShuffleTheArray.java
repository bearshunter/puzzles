package org.dpo.lc.top150.arrays;

import java.util.Arrays;

public class ShuffleTheArray {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 2, 3};
        //1,2,1,2,1,2
        shuffleExtraSpace(nums, 3);
    }


    public static int[] shuffleExtraSpace(int[] nums, int n) {
        int[] result = new int[2 * n];
        int pointer = 0;
        for (int i = 0; i < n; i++) {
            result[pointer] = nums[i];
            pointer++;
            result[pointer] = nums[i + n];
            pointer++;
        }
        System.out.println(Arrays.toString(result));
        return result;
    }

}
