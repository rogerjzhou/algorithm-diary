package P0015_3sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 15 - 3Sum
 * https://leetcode.com/problems/3sum/
 *
 * Approach:
 * - Sort the array
 * - Fix one number, use two pointers to find the remaining two
 * - Skip duplicates to avoid repeated triplets
 *
 * Time: O(n^2), Space: O(1) (excluding output)
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            int curr = nums[i];

            while(left < right) {

                int currSum = curr + nums[left] + nums[right];

                if(currSum == 0) {
                    result.add(Arrays.asList(curr, nums[left], nums[right]));
                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left - 1]) left++;
                    while(left < right && nums[right] == nums[right + 1]) right--;
                } else if(currSum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }
}
