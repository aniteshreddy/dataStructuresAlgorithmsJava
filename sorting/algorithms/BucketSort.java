package com.sorting.algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BucketSort {

    static int hash(int num, int bucketRange, int noOfBuckets) {
        int bucketNumber = (int) Math.ceil((double) num / bucketRange);
        if (bucketNumber == noOfBuckets)
            return --bucketNumber;
        return bucketNumber;
    }

    void sort(int[] arr, int length) {
        if (length <= 0) {
            return;
        }
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();

        int range = max - min;
        int noOfBuckets = 5;
        int bucketRange = (int) Math.ceil((double) range / noOfBuckets);

        List<Integer>[] buckets = new List[noOfBuckets];
        for (int i = 0; i < noOfBuckets; i++) {
            buckets[i] = new LinkedList<>();
        }
        for (int num : arr) {
            buckets[hash(num, bucketRange, noOfBuckets)].add(num);
        }
        for (List<Integer> bucket : buckets)
            Collections.sort(bucket);
        
        int j = 0;
        for (List<Integer> bucket : buckets)
            for (int num : bucket) {
                arr[j++] = num;

            }

    }

    public static void main(String[] args) {

        int[] arr = { 12, 13, 9, 7, 3, 4, 21, 24, 1 };
        new BucketSort().sort(arr, arr.length);
        for (int a : arr) {
            System.out.print(a + " ");
        }

    }
}
