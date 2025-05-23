package P0035_BinarySearch;

public class BinarySearch {

    /**
     * LeetCode 35 - Search Insert Position
     * https://leetcode.com/problems/search-insert-position/
     *
     * Approach (Binary Search - Classic Template with left <= right):
     * - Perform binary search to find the target
     * - If the target exists, return its index
     * - If not found, return the index where it should be inserted (left)
     *
     * Key idea:
     * - The loop continues as long as left <= right
     * - If target is not found, left will be pointing to the correct insert position
     *
     * Time: O(log n), where n is the number of elements in the array
     * Space: O(1), constant extra space
     */
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1; // right is inclusive here

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (nums[mid] == target) {
                    return mid; // found target
                } else if (nums[mid] < target) {
                    left = mid + 1; // move right
                } else {
                    right = mid - 1; // move left
                }
            }

            // target not found, left is the correct insert position
            return left;
        }
    }


}
