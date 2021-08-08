package com.sorting.algorithms;


import java.util.Arrays;

public class RadixSort {

    void countSort(int[] arr, int n, int pos) {
        int[] count = new int[10];
        int[] b = new int[n];
        int i = 0;
        Arrays.fill(count, 0);
        for (i = 0; i < n; i++) {
            ++count[(arr[i] / pos) % 10];
        }

        for(i=1;i<=9;i++)
            count[i]=count[i]+count[i-1];
        

        for (i = n - 1; i >= 0; i--) {
            b[--count[(arr[i] / pos) % 10]] = arr[i];
        }
        for (i = 0; i < n; i++)
            arr[i] = b[i];

    }

    void sort(int[] arr, int n) {

        int max = Arrays.stream(arr).max().getAsInt();
        for (int i = 1; max / i > 0; i = i * 10) {
            countSort(arr, n, i);
        }

    }

    public static void main(String[] args) {
        int[] arr = { 100, 889, 978, 378, 458, 27, 1 };
        new RadixSort().sort(arr, arr.length);
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }
}
