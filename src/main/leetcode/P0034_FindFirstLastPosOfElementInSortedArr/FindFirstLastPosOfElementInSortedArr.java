package P0034_FindFirstLastPosOfElementInSortedArr;

public class FindFirstLastPosOfElementInSortedArr {
    /**
     * LeetCode 34 - Find First and Last Position of Element in Sorted Array
     * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
     *
     * Approach (Binary Search - Lower and Upper Bound):
     * - Use binary search twice to find:
     *     1. The first position where nums[i] >= target (lower bound)
     *     2. The first position where nums[i] > target (upper bound), then subtract 1
     * - If target does not exist in the array, lower bound will point to a value not equal to target
     * - Return [-1, -1] in that case
     *
     * Time: O(log n) for each binary search → total O(log n)
     * Space: O(1), constant extra space
     */
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int first = lowerBound(nums, target);
            int last = upperBound(nums, target) - 1;

            // Check if target exists in the array
            if (first == nums.length || nums[first] != target) {
                return new int[]{-1, -1};
            }

            return new int[]{first, last};
        }

        // Find the first index where nums[i] >= target
        private int lowerBound(int[] nums, int target) {
            int left = 0;
            int right = nums.length;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (nums[mid] < target) {
                    left = mid + 1; // search right half
                } else {
                    right = mid; // search left half including mid
                }
            }

            return left;
        }

        // Find the first index where nums[i] > target
        private int upperBound(int[] nums, int target) {
            int left = 0;
            int right = nums.length;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (nums[mid] <= target) {
                    left = mid + 1; // search right half
                } else {
                    right = mid; // search left half including mid
                }
            }

            return left;
        }
    }
}
