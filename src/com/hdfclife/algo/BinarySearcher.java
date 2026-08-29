package com.hdfclife.algo;

public class BinarySearcher {

    public static boolean search(int[] arr, int target) {

        return searchRecursive(arr, target, 0, arr.length - 1);
    }

    private static boolean searchRecursive(int[] arr, int target, int left, int right)
    {

        if (left > right) {
            return false;
        }

        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            return true;
        }

        if (target < arr[mid]) {
            return searchRecursive(arr, target, left,mid - 1);
        }

        return searchRecursive(arr, target, mid + 1, right);
    }
}
