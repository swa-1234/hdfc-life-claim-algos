package com.hdfclife.algo;

import com.hdfclife.exception.PairNotFoundException;

import java.util.Arrays;

public class PairSumSolver {

    public static String bruteForce(int[] arr, int target) {

        for (int i = 0; i < arr.length; i++) {

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[i] + arr[j] == target) {
                    int first = Math.min(arr[i], arr[j]);
                    int second = Math.max(arr[i], arr[j]);

                    return first + " + " + second;
                }
            }
        }

        throw new PairNotFoundException(
                "No pair found for target " + target
        );
    }

    public static String twoPointer(int[] arr, int target) {

        int[] copy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy);

        int left = 0;
        int right = copy.length - 1;

        while (left < right) {

            int sum = copy[left] + copy[right];

            if (sum == target) {
                return copy[left] + " + " + copy[right];
            }

            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        throw new PairNotFoundException(
                "No pair found for target " + target
        );
    }
}
