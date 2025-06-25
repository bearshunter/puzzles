package org.dpo.algos;


public class SearchSortedList {

    public static void main(String[] args) {
        int[] numbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 5;
        int index1 = binarySearch(numbers, target);
        System.out.println("Index of " + target + ": " + index1);

        int index2 = binarySearchRecursive(numbers, target);
        System.out.println("Index of " + target + ": " + index2);
    }


    private static int binarySearchRecursive(int[] arr, int target) {
        final int lastElementIndex = arr.length - 1;
        return binarySearchRecursive(arr, target, 0, lastElementIndex);
    }

    private static int binarySearchRecursive(int[] arr, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;

        if (arr[mid] == target) {
            return mid;
        }

        if (arr[mid] < target) {
            return binarySearchRecursive(arr, target, mid + 1, end);
        }

        return binarySearchRecursive(arr, target, start, mid - 1);
    }


    public static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
