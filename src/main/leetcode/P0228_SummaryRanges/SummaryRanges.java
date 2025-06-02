package P0228_SummaryRanges;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 228 - Summary Ranges
 *
 * Approach:
 * - Use two pointers (`start` and `end`) to track the current range.
 * - Iterate through the array from index 1.
 * - If the current number is consecutive (i.e., == end + 1), extend the range.
 * - Otherwise, finalize the previous range and start a new one.
 * - After the loop, don't forget to add the last tracked range.
 *
 * Time Complexity: O(n) — we go through the array once.
 * Space Complexity: O(1) — not counting the output list.
 *
 * Edge Cases:
 * - Empty array → return empty list.
 * - Single element → return that element as a string.
 */
public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;

        int start = nums[0];
        int end = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == end + 1) {
                // Extend current range
                end = nums[i];
            } else {
                // Finalize the previous range
                result.add(start == end ? String.valueOf(start) : start + "->" + end);
                start = end = nums[i];
            }
        }

        // Add the last range
        result.add(start == end ? String.valueOf(start) : start + "->" + end);
        return result;
    }

}
