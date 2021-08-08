package com.sorting.algorithms;

import java.util.*;
public class BubbleSort{

    static int[] sort(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        return arr;
    }


    public static void main(String[] args) {
        //
        int[] arr ={1,8,9,3,4,2};

      for(int a:sort(arr)){
          System.out.print(a+" ");
      }

    }
}