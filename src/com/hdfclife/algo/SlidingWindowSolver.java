package com.hdfclife.algo;

import com.hdfclife.exception.InvalidWindowException;

public class SlidingWindowSolver {

    public static int maxSum(int[] arr, int k) {

        if (k <= 0 || k > arr.length) {
            throw new InvalidWindowException("Invalid window size: " + k);
        }

        int windowSum = 0;

        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        int maxSum = windowSum;

        for (int i = k; i < arr.length; i++) {

            windowSum += arr[i];
            windowSum -= arr[i - k];

            if (windowSum > maxSum) {
                maxSum = windowSum;
            }
        }

        return maxSum;
    }
}
