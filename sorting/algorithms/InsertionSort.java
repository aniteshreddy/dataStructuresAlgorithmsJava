package com.sorting.algorithms;


public class InsertionSort {

    static int[] sort(int[] arr) {
        for(int i=0;i<arr.length;i++){
            int key=arr[i];
            int j=i-1;
            while(j>=0 && arr[j]>key){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {15, 1, 8, 9, 3, 4, 2 ,110};

        for (int a : sort(arr)) {
            System.out.print(a + " ");
        }
    }
}

