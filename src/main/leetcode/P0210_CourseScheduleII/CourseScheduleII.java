package P0210_CourseScheduleII;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode 210 - Course Schedule II
 * https://leetcode.com/problems/course-schedule-ii/
 *
 * Approach (BFS Topological Sort - Kahn's Algorithm):
 * - Build a directed graph using an adjacency list
 * - Maintain an in-degree array to track how many prerequisites each course has
 * - Add all courses with in-degree 0 (no prerequisites) to a queue
 * - While the queue is not empty:
 *     - Dequeue a course and add it to the result
 *     - Decrease the in-degree of its neighbors (dependent courses)
 *     - If a neighbor's in-degree becomes 0, add it to the queue
 * - If all courses are added to the result, return the result as a valid order
 * - If not all courses are processed, a cycle exists → return an empty array
 *
 * Time: O(V + E), where V = numCourses and E = number of prerequisites
 * Space: O(V + E), for the graph and in-degree array
 */
public class CourseScheduleII {

    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {

            List<List<Integer>> graph = new ArrayList<>();
            int[] inDegree = new int[numCourses];

            for (int i = 0; i < numCourses; i++) {
                graph.add(new ArrayList<>());
            }

            for(int[] curr : prerequisites) {
                graph.get(curr[1]).add(curr[0]);
                inDegree[curr[0]]++;
            }

            Queue<Integer> queue = new LinkedList<>();
            for(int i = 0; i < numCourses; i++) {
                if(inDegree[i] == 0) {
                    queue.offer(i);
                }
            }
            int[] result = new int[numCourses];
            int index = 0;

            while(!queue.isEmpty()) {
                int course = queue.poll();
                result[index++] = course;

                for(int neighbor : graph.get(course)) {
                    inDegree[neighbor]--;
                    if(inDegree[neighbor] == 0) {
                        queue.offer(neighbor);
                    }
                }
            }

            return index == numCourses ? result : new int[0];
        }
    }
}
