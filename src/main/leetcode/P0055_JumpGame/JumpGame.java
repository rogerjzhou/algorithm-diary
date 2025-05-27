package P0055_JumpGame;

/**
 * LeetCode 55 - Jump Game
 * https://leetcode.com/problems/jump-game/
 *
 * Approach (Greedy):
 * - Use a greedy strategy to track the farthest index that can be reached so far
 * - Iterate through the array from left to right, up to the current farthest reachable index
 * - At each index i, update the farthest reachable position: farthest = max(farthest, i + nums[i])
 * - If at any point farthest >= last index, return true (can reach the end)
 * - If the loop ends and farthest < last index, return false (stuck before the end)
 *
 * Time: O(n), where n is the length of the input array
 * Space: O(1), constant space
 */
public class JumpGame {
    class Solution {

        public boolean canJump(int[] nums) {

            int farthest = 0;
            for (int i = 0; i <= farthest; i++) {

                farthest = Math.max(farthest, nums[i] + i);
                if (farthest >= nums.length - 1) {
                    return true;
                }

            }
            return false;
        }
    }
}
