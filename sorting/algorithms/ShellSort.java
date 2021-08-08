
package com.sorting.algorithms;

public class ShellSort {

    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    void sort(int[] arr, int n) {
        int gap;
        for (gap = n / 2; gap >= 1; gap /= 2) {
            
            for (int j = gap; j < n; j++) {
                for (int i = j-gap; i >= 0; i = i - gap) {
                    
                    if (arr[i + gap] > arr[i]) {
                        break;
                    } else {
                        swap(arr, i + gap, i);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 100, 889, 978, 378, 458, 27, 1 };
        new ShellSort().sort(arr, arr.length);
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }
}
