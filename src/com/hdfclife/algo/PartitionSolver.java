package com.hdfclife.algo;

import java.util.Arrays;

public class PartitionSolver {

    public static int[] partition(int[] original, int pivot) {

        int[] arr = Arrays.copyOf(original, original.length);

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            while (left <= right && arr[left] <= pivot) {
                left++;
            }

            while (left <= right && arr[right] > pivot) {
                right--;
            }

            if (left < right) {

                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                left++;
                right--;
            }
        }

        return arr;
    }
}
