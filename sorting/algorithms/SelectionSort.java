
package com.sorting.algorithms;

public class SelectionSort {

    static void sort(int[] arr) {
        for(int i=0;i<arr.length-1;i++){
            int min=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[min]>arr[j]){
                    min=j;   
                }
            }
            int temp= arr[i];
            arr[i]=arr[min];
            arr[min]=temp;
        }
      
    }

    public static void main(String[] args) {
        int[] arr = { 1, 8, 9, 3, 4, 2 };
        sort(arr);
        for (int a :arr ) {
            System.out.print(a + " ");
        }
    }
}