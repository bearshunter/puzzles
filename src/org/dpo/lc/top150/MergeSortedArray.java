package org.dpo.lc.top150;

import java.util.Arrays;

public class MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};

        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] firstArray, int elementsInFirstArray, int[] secondArray, int elementsInSecondArray) {
        int pointerOnFirstArray = elementsInFirstArray - 1;
        int pointerOnSecondArray = elementsInSecondArray - 1;
        int pointerForResultArray = elementsInFirstArray + elementsInSecondArray - 1; // or firstArray.length - 1

        while (pointerOnSecondArray >= 0 && pointerOnFirstArray >= 0) {

            if (firstArray[pointerOnFirstArray] > secondArray[pointerOnSecondArray]) {
                firstArray[pointerForResultArray] = firstArray[pointerOnFirstArray];
                pointerOnFirstArray--;
            } else {
                firstArray[pointerForResultArray] = secondArray[pointerOnSecondArray];
                pointerOnSecondArray--;
            }
            pointerForResultArray--;
        }

        while (pointerOnSecondArray >= 0) {
            firstArray[pointerForResultArray] = secondArray[pointerOnSecondArray];
            pointerOnSecondArray--;
            pointerForResultArray--;
        }
    }
}
