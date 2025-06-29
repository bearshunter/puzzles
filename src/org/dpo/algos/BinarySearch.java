package org.dpo.algos;

public class BinarySearch {
    public static void main(String[] args) {
        int[] numbers = new int[]{1, 2, 3, 4, 5,6,7,8};
        int target = 8;
        int resIndex = binarySearch(numbers, target);
        System.out.println(resIndex);
    }

    private static int binarySearch(int[] numbers, int target) {
        int endIndex = numbers.length - 1;
        int startIndex = 0;
        while (startIndex <= endIndex) {
            int mid = startIndex + (endIndex - startIndex) / 2;

            if (numbers[mid] == target) {
                return mid;
            }
            if (numbers[mid] < target) {
                startIndex = mid + 1;
            } else{
                endIndex = mid - 1;
            }

        }

        return -1;
    }
}
