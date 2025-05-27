package P0202_HappyNumber;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    /**
     * LeetCode 202 - Happy Number
     * https://leetcode.com/problems/happy-number/
     *
     * Approach (Floyd's Cycle Detection - Tortoise and Hare):
     * - Use two pointers: slow (1 step at a time), fast (2 steps at a time)
     * - If we reach 1, return true (happy number)
     * - If slow == fast (and not 1), we’ve detected a cycle → return false
     *
     * This avoids using extra space compared to the HashSet approach.
     *
     * Time Complexity: O(log n * m), where:
     *     - log n is for computing the digit square sum
     *     - m is the number of different states (≤ 243)
     * Space Complexity: O(1), constant space
     */
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);

        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }

        return fast == 1;
    }

    /**
     * LeetCode 202 - Happy Number
     * https://leetcode.com/problems/happy-number/
     *
     * Approach (HashSet to detect cycle):
     * - Repeatedly replace the number with the sum of the squares of its digits
     * - Use a HashSet to track all numbers seen in the process
     * - If we reach 1, the number is happy → return true
     * - If we enter a cycle (i.e., the number is seen before), it's not happy → return false
     *
     * Time Complexity: O(log n * m), where:
     *     - log n is the number of digits in the number
     *     - m is the maximum number of different sums we might see (bounded by a constant ≤ 243)
     * Space Complexity: O(m) due to the HashSet storing intermediate numbers
     */
    public boolean isHappy1(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            n = getNext(n);
            if (set.contains(n)) {
                return false;
            } else {
                set.add(n);
            }
        }
        return true;
    }

    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n = n / 10;
        }
        return sum;
    }

}
