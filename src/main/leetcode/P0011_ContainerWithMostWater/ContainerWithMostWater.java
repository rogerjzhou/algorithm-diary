package P0011_ContainerWithMostWater;

/**
 * LeetCode 11 - Container With Most Water
 * https://leetcode.com/problems/container-with-most-water/
 *
 * Approach (Two Pointers):
 * - Initialize two pointers: one at the start (`left`), one at the end (`right`)
 * - At each step, calculate the area formed between `left` and `right`
 *     - Area = min(height[left], height[right]) * (right - left)
 * - Update the maximum area if this is larger
 * - Move the shorter line inward:
 *     - If height[left] < height[right], move `left` forward
 *     - Else, move `right` backward
 * - Continue until the two pointers meet
 *
 * Time: O(n), each element is visited at most once
 * Space: O(1), constant extra space
 */
public class ContainerWithMostWater {

    class Solution {
        public int maxArea(int[] height) {

            int max = 0;
            int left = 0;
            int right = height.length - 1;

            while(left < right) {
                int currArea = Math.min(height[left], height[right]) * (right - left);
                max = Math.max(max, currArea);
                if(height[left] <= height[right]) {
                    left++;
                } else {
                    right--;
                }
            }

            return max;

        }
    }

}
