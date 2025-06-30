package org.dpo.leetcode.top150;

import java.util.Arrays;

public class FindCountInSortedArray {


    public static void main(String[] args) {
        int[] ints = new int[]{1, 2, 2, 3, 3, 4, 4};
        int res = countUniqueElements(ints);
        System.out.println(res);
    }

    /**
     *
     * Если массив пустой, возвращаем 0.
     * Поскольку массив отсортирован по убыванию, дубликаты будут идти подряд.
     * Мы начинаем с k = 1, так как первый элемент (nums[0]) всегда уникален.
     * Проходим по массиву с помощью индекса i, начиная с 1. Если текущий элемент (nums[i]) отличается от предыдущего (nums[i-1]), он уникален.
     * В этом случае записываем его на позицию k и увеличиваем k.
     * В конце k будет содержать количество уникальных элементов, а первые k элементов массива nums будут содержать уникальные элементы в правильном порядке.
     * [1, 2, 2, 3, 3, 4, 4]
     * [1, 2, 2, 3, 3, 4, 4]
     * [1, 2, 3, 3, 3, 4, 4]
     * [1, 2, 3, 3, 3, 4, 4]
     * [1, 2, 3, 4, 3, 4, 4]
     * [1, 2, 3, 4, 3, 4, 4]
     * 4
     */

    private static int countUniqueElements(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return 0;
        }
        int k = 1;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] != numbers[i - 1]) {
                numbers[k] = numbers[i];
                k++;
            }
            System.out.println(Arrays.toString(numbers));

        }
        return k;
    }
}
