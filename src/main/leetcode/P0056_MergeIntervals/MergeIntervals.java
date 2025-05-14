package P0056_MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 56 - Merge Intervals
 * https://leetcode.com/problems/merge-intervals/
 *
 * Approach:
 * - Sort the intervals by start time
 * - Initialize the first interval as the current one
 * - Iterate through the rest:
 *     - If overlapping (current end >= next start), merge them by updating the end
 *     - Else, add current to result and move to next interval
 * - Add the last interval to the result
 *
 * Time: O(n log n) for sorting
 * Space: O(n) for the output list
 */
public class MergeIntervals {

    class Solution {
        public int[][] merge(int[][] intervals) {

            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
            List<int[]> resultList = new ArrayList<>();
            int[] current = intervals[0];

            for(int i = 1; i < intervals.length; i++) {
                int[] next = intervals[i];
                if(current[1] >= next[0]) {
                    current[1] = Math.max(current[1], next[1]);
                } else {
                    resultList.add(current);
                    current = next;
                }
            }
            resultList.add(current);

            int[][] result = new int[resultList.size()][];

            for(int i = 0; i < resultList.size(); i++) {
                result[i] = resultList.get(i);
            }

            return resultList.toArray(new int[resultList.size()][]);

        }
    }

}
