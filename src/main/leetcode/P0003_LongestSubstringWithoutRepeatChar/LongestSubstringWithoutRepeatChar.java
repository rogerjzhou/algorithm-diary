package P0003_LongestSubstringWithoutRepeatChar;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 3 - Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Approach:
 * - Use sliding window with two pointers: `start` and `i`
 * - Use a HashSet to track characters in the current window
 * - Move `i` forward, adding characters to the set
 *     - If a duplicate is found, move `start` forward and remove characters from the set
 * - At each step, update the maximum window size (i - start + 1)
 *
 * Time: O(n), each character is visited at most twice
 * Space: O(k), where k is the size of the character set (e.g. 26 or 128)
 */
public class LongestSubstringWithoutRepeatChar {

    class Solution {
        public int lengthOfLongestSubstring(String s) {

            int start = 0;
            Set<Character> set = new HashSet<>();
            int longest = 0;

            for(int i = 0; i < s.length(); i++) {

                char curr = s.charAt(i);
                while(start < s.length() && set.contains(curr)) {
                    set.remove(s.charAt(start));
                    start++;
                }
                set.add(curr);
                longest = Math.max(longest, i - start + 1);
            }

            return longest;

        }
    }

}
