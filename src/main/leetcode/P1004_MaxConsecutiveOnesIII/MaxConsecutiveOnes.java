package P1004_MaxConsecutiveOnesIII;

/**
 * LeetCode 1004 - Max Consecutive Ones III
 * https://leetcode.com/problems/max-consecutive-ones-iii/
 *
 * Approach (Sliding Window):
 * - Use a sliding window with two pointers (left and right)
 * - Expand the window by moving right (i) forward
 * - Count the number of zeros in the current window (zeroCounter)
 * - If the number of zeros exceeds k:
 *     - Shrink the window from the left until there are at most k zeros
 *     - Adjust zeroCounter if zeros are removed
 * - At each step, track the maximum window length
 *
 * Time: O(n), where n is the length of the input array
 * Space: O(1), constant extra space
 */
public class MaxConsecutiveOnes {

    class Solution {
        public int longestOnes(int[] nums, int k) {

            int zeroCounter = 0;
            int left = 0;
            int max = 0;

            for(int i = 0; i < nums.length; i++) {

                if(nums[i] == 0) {
                    zeroCounter++;
                    while(zeroCounter > k) {
                        if(nums[left++] == 0) {
                            zeroCounter--;
                        }
                    }
                }

                max = Math.max(max, i - left + 1);

            }
            return max;
        }
    }
}
