package P0012_IntegerToRoman;

/**
 * LeetCode 12 - Integer to Roman
 * https://leetcode.com/problems/integer-to-roman/
 *
 * Approach:
 * 1. Define an array of Roman numeral values and their corresponding symbols, sorted from high to low.
 * 2. Iterate through the array.
 *    - While the current number is greater than or equal to the value,
 *      append the symbol to the result and subtract the value from the number.
 * 3. Return the constructed Roman numeral string.
 *
 * Time Complexity: O(1)
 *   - Because the number is at most 3999, the loop runs at most a fixed number of times.
 *
 * Space Complexity: O(1)
 *   - No extra space beyond constant-sized arrays and output string.
 */
public class IntegerToRoman {

    class Solution {
        public String intToRoman(int num) {
            int[] values =    {1000, 900, 500, 400, 100,  90,  50,  40,  10,   9,   5,   4,   1};
            String[] romans = {"M",  "CM","D", "CD","C", "XC","L", "XL","X", "IX","V", "IV","I"};

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < values.length; i++) {
                while (num >= values[i]) {
                    sb.append(romans[i]);
                    num -= values[i];
                }
            }

            return sb.toString();
        }
    }

}
