package com.hdfclife.algo;

import java.util.HashSet;
import java.util.Set;

public class UniqueSubstringSolver {

    public static int longestUniqueSubstring(String text) {

        Set<Character> set = new HashSet<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < text.length(); right++) {

            char current = text.charAt(right);

            while (set.contains(current)) {
                set.remove(text.charAt(left));
                left++;
            }

            set.add(current);

            int currentLength = right - left + 1;

            if (currentLength > maxLength) {
                maxLength = currentLength;
            }
        }

        return maxLength;
    }
}
