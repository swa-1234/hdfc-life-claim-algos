package com.hdfclife;

import com.hdfclife.algo.BinarySearcher;
import com.hdfclife.algo.PairSumSolver;
import com.hdfclife.algo.PalindromeChecker;
import com.hdfclife.algo.PartitionSolver;
import com.hdfclife.algo.SlidingWindowSolver;
import com.hdfclife.algo.UniqueSubstringSolver;
import com.hdfclife.exception.InvalidIndexException;
import com.hdfclife.exception.PairNotFoundException;
import com.hdfclife.store.ClaimAmountStore;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        ClaimAmountStore store = new ClaimAmountStore();

        store.add(25000);
        store.add(18000);
        store.add(42000);
        store.add(15000);
        store.add(31000);
        store.add(9000);

        int[] seed = store.toArray();

        System.out.println(
                "Seed array → " + format(seed)
        );

        store.insert(2, 22000);

        System.out.println(
                "After insert(2, 22000) → "
                        + format(store.toArray())
        );

        System.out.println(
                "Shift count for that insert → "
                        + store.getLastShiftCount()
        );

        store.delete(2);

        System.out.println(
                "After delete(2) → "
                        + format(store.toArray())
        );

        try {

            String bruteForcePair =
                    PairSumSolver.bruteForce(seed, 57000);

            System.out.println(
                    "Brute-force pair for 57000 → "
                            + bruteForcePair
            );

        } catch (PairNotFoundException e) {

            System.out.println(
                    "Caught message for pair target 57000: "
                            + e.getMessage()
            );
        }

        try {

            String twoPointerPair =
                    PairSumSolver.twoPointer(seed, 57000);

            System.out.println(
                    "Two-pointer pair for 57000 → "
                            + twoPointerPair
            );

        } catch (PairNotFoundException e) {

            System.out.println(
                    "Caught message for pair target 57000: "
                            + e.getMessage()
            );
        }

        System.out.println(
                "Palindrome 12321 → "
                        + PalindromeChecker.isPalindrome(12321)
        );

        System.out.println(
                "Palindrome 18500 → "
                        + PalindromeChecker.isPalindrome(18500)
        );

        int[] partitioned =
                PartitionSolver.partition(seed, 20000);

        System.out.println(
                "Partition around 20000 → "
                        + format(partitioned)
        );

        int maxSum =
                SlidingWindowSolver.maxSum(seed, 3);

        System.out.println(
                "Sliding-window max for k=3 → "
                        + maxSum
        );

        int longest =
                UniqueSubstringSolver
                        .longestUniqueSubstring("TERMULIPTERM");

        System.out.println(
                "Longest unique substring of TERMULIPTERM → "
                        + longest
        );

        int[] sortedSeed = Arrays.copyOf(
                seed,
                seed.length
        );

        Arrays.sort(sortedSeed);

        boolean found15000 =
                BinarySearcher.search(sortedSeed, 15000);

        System.out.println(
                "Binary search 15000 → "
                        + (found15000 ? "found" : "not found")
        );

        boolean found999 =
                BinarySearcher.search(sortedSeed, 999);

        System.out.println(
                "Binary search 999 → "
                        + (found999 ? "found" : "not found")
        );

        try {

            store.insert(99, 1);

        } catch (InvalidIndexException e) {

            System.out.println(
                    "Caught message for invalid insert index 99 → "
                            + e.getMessage()
            );
        }

        try {

            PairSumSolver.bruteForce(seed, 1);

        } catch (PairNotFoundException e) {

            System.out.println(
                    "Caught message for pair target 1 → "
                            + e.getMessage()
            );
        }
    }

    private static String format(int[] arr) {
        return Arrays.toString(arr)
                .replace("[", "")
                .replace("]", "");
    }
}
