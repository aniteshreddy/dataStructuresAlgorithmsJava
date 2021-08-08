
package com.sorting.algorithms;

import java.util.Arrays;

public class CountingSort {

    static void sort(int[] arr, int length) {
        int max = Arrays.stream(arr).max().getAsInt();

        int[] count = new int[max + 1];
        Arrays.fill(count, 0);
        int i = 0;
        int[] b = new int[length];
        for (i = 0; i < length; i++) {
            ++count[arr[i]];

        }
        for (i = 1; i <= max; i++) {
            count[i] = count[i] + count[i - 1];
        }
        for (i = length - 1; i >= 0; i--) {
            b[--count[arr[i]]] = arr[i];
        }
        for (i = 0; i < length; i++)
            arr[i] = b[i];
    }

    public static void main(String[] args) {

        int[] arr = { 12, 13, 9, 7, 3, 4, 21, 24, 1 };
        sort(arr, arr.length);
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }
}
