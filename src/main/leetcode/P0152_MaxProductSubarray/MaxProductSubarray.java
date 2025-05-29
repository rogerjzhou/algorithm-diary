package P0152_MaxProductSubarray;

/**
 * LeetCode 152 - Maximum Product Subarray
 * https://leetcode.com/problems/maximum-product-subarray/
 *
 * Approach (Dynamic Programming with tracking min/max):
 * - Maintain two variables, `maxProd` and `minProd`, representing the maximum and minimum product
 *   ending at the current position. A negative number can flip max to min, so both must be tracked.
 * - Initialize `maxProd = nums[0]`, `minProd = nums[0]`, and `result = nums[0]`.
 * - Iterate over the array from index 1 to end:
 *     1. If `nums[i]` is negative, swap `maxProd` and `minProd` to account for sign change.
 *     2. Update `maxProd = max(nums[i], maxProd * nums[i])`.
 *     3. Update `minProd = min(nums[i], minProd * nums[i])`.
 *     4. Update `result = max(result, maxProd)`.
 * - Return `result` as the maximum product of any contiguous subarray.
 *
 * Time: O(n), where n = nums.length
 * Space: O(1), constant extra space
 */
public class MaxProductSubarray {

    public int maxProduct(int[] nums) {
        int maxProd = nums[0], minProd = nums[0], result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];
            if (x < 0) {
                int tmp = maxProd;
                maxProd = minProd;
                minProd = tmp;
            }
            maxProd = Math.max(x, maxProd * x);
            minProd = Math.min(x, minProd * x);
            result = Math.max(result, maxProd);
        }
        return result;
    }
}
