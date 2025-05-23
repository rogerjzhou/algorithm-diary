package P0035_SearchInsertPosition;

public class SearchInsertPosition {

    /**
     * LeetCode 35 - Search Insert Position
     * https://leetcode.com/problems/search-insert-position/
     *
     * Approach (Binary Search - Lower Bound Template):
     * - Use a binary search to find the first index where nums[i] >= target
     * - Initialize left = 0, right = nums.length (right is exclusive)
     * - In each iteration:
     *     - Compute mid as the average of left and right
     *     - If nums[mid] < target:
     *         - The target must be to the right of mid, move left to mid + 1
     *     - Else:
     *         - nums[mid] could be the answer, shrink the search space from the right
     * - Loop ends when left == right
     * - Return left as the insert position (first index where nums[i] >= target)
     *
     * Time: O(log n), where n is the number of elements in the array
     * Space: O(1), constant extra space
     */
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int left = 0;
            int right = nums.length; // right is exclusive to fit the lower bound pattern

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (nums[mid] < target) {
                    left = mid + 1; // eliminate left half including mid
                } else {
                    right = mid; // keep mid and search in the left half
                }
            }

            // left is now the first index where nums[left] >= target
            return left;
        }
    }

}
