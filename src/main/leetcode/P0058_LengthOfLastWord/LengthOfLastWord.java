package P0058_LengthOfLastWord;

public class LengthOfLastWord {

    class Solution {

        /**
         * LeetCode 58 - Length of Last Word
         * https://leetcode.com/problems/length-of-last-word/
         *
         * Approach (Trim + Split):
         * - Use trim() to remove leading and trailing whitespace
         * - Use split(" ") to divide the string into words
         * - Return the length of the last word in the array
         *
         * Time: O(n), where n is the length of the string (due to trim and split)
         * Space: O(n), due to storing the array of words
         */
        public int lengthOfLastWord2(String s) {

            String str = s.trim();
            String[] strArr = str.split(" ");

            return strArr.length == 0 ? 0 : strArr[strArr.length - 1].length();

        }

        /**
         * LeetCode 58 - Length of Last Word
         * https://leetcode.com/problems/length-of-last-word/
         *
         * Approach (Reverse Scan):
         * - Start from the end of the string and skip any trailing spaces
         * - Count the number of characters until the next space or beginning of the string
         * - This gives the length of the last word without using extra space
         *
         * Time: O(n), where n is the length of the input string
         * Space: O(1), constant space (no extra data structures used)
         */
        public int lengthOfLastWord(String s) {
            int length = 0;
            int i = s.length() - 1;

            // Skip trailing spaces
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }

            // Count characters of last word
            while (i >= 0 && s.charAt(i) != ' ') {
                length++;
                i--;
            }

            return length;
        }
    }
}
