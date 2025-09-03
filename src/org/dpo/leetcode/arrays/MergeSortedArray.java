package org.dpo.leetcode.arrays;

import java.util.Arrays;

public class MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};

        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int last = m + n - 1;
        int p1 = m - 1;
        int p2 = n - 1;
        while (p2 >= 0) {
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[last] = nums1[p1];
                p1--;
            } else {
                nums1[last] = nums2[p2];
                p2--;
            }
            last--;
        }
    }
}
