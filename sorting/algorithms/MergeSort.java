
package com.sorting.algorithms;

public class MergeSort {

    void mergeSort(int[] arr, int l, int m, int h) {
        int n1 = m - l + 1;
        int n2 = h - m;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++)
            left[i] = arr[l + i];

        for (int j = 0; j < n2; j++)
            right[j] = arr[m + 1 + j];

        int i = 0, j = 0, k = l;

        while (i < n1 && j < n2) {
            if (left[i] < right[j])
                arr[k++] = left[i++];
            else
                arr[k++] = right[j++];
        }

        while(i<n1)
            arr[k++]=left[i++];
        
        while(j<n2)
            arr[k++]=right[j++];

    }

    void sort(int[] arr, int l, int h) {

        if (l < h) {
            int m = (l + h) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, h);
            mergeSort(arr, l, m, h);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 10, 8, 9, 3, 4, 2, 15 };

        int high = arr.length - 1;
        new MergeSort().sort(arr, 0, high);

        for (int a : arr) {
            System.out.print(a + " ");
        }

    }
}
