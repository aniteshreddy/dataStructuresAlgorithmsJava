package com.sorting.algorithms;


public class QuickSort {

    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;

        while (i < j) {

            while (i <= high && arr[i] <= pivot) {

                i++;
            }

            while (j >= 0 && arr[j] > pivot) {
                j--;
            }
            if (i < j) {
                swap(arr, i, j);
            }

        }
        swap(arr, low, j);
        return j;

    }

    void sort(int[] arr, int low, int high) {

        if (low < high) {
            int pi = partition(arr, low, high);

            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }

    }

    public static void main(String[] args) {
        int[] arr = { 10, 8, 9, 3, 4, 2, 15 };

        int high = arr.length - 1;
        new QuickSort().sort(arr, 0, high);
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }
}
