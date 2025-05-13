package P0434_NumberOfSegments;

/**
 * LeetCode 434 - Number of Segments in a String
 * https://leetcode.com/problems/number-of-segments-in-a-string/
 *
 * Approach:
 * - Traverse the string
 * - Count the start of each non-space segment
 * - Skip over the characters of each segment
 *
 * Time: O(n), Space: O(1)
 */
public class NumberOfSegments {
    class Solution {
        public int countSegments(String s) {
            if(s.isBlank()) return 0;
            int length = 0;

            for(int i = 0; i < s.length(); i++) {

                if(s.charAt(i) != ' ') {
                    while(i + 1 < s.length() && s.charAt(i + 1) != ' ') {
                        i++;
                    }
                    length++;
                }
            }
            return length;
        }
    }
}
