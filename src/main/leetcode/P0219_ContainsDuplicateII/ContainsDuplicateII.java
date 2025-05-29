package P0219_ContainsDuplicateII;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicateII {

    /**
     * LeetCode 219 - Contains Duplicate II
     * https://leetcode.com/problems/contains-duplicate-ii/
     *
     * Approach (HashMap):
     * - Iterate over the array while storing each number's latest index.
     * - If the number has been seen before, compare the current index with the stored index.
     * - If the distance is ≤ k, return true immediately.
     * - Otherwise, update the stored index for that number.
     *
     * Time: O(n), where n is the length of the array
     * Space: O(n), for the HashMap storing the last seen index of each number
     */
    public boolean containsNearbyDuplicateWithMap(int[] nums, int k) {

        Map<Integer, Integer> lastIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (lastIndex.containsKey(nums[i])) {
                int j = lastIndex.get(nums[i]);
                if (i - j <= k) {
                    return true;  // Found two indices with same value and distance ≤ k
                }
            }
            lastIndex.put(nums[i], i);  // Update last seen index
        }

        return false;  // No such pair found
    }

    /**
     * LeetCode 219 - Contains Duplicate II
     * https://leetcode.com/problems/contains-duplicate-ii/
     *
     * Approach (Sliding Window using HashSet):
     * - Use a sliding window of size at most k to track unique elements.
     * - At each step, check if the current number already exists in the window.
     *     - If yes, a duplicate within distance k is found → return true.
     * - Maintain the window size by removing the element that is now out of range (i - k - 1).
     *
     * Time: O(n), where n is the length of the array
     * Space: O(min(n, k)), the size of the sliding window
     */
    public boolean containsNearbyDuplicateWithSet(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            // Keep window size ≤ k by removing the element k+1 steps behind
            if (i > k) {
                window.remove(nums[i - k - 1]);
            }

            // If current value already exists in the window, return true
            if (!window.add(nums[i])) {
                return true;
            }
        }

        return false;  // No duplicate within distance k found
    }
}
