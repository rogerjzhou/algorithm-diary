package P0207_CourseSchedule;

import java.util.*;


public class CourseSchedule {

    /**
     * LeetCode 207 - Course Schedule
     * https://leetcode.com/problems/course-schedule/
     *
     * Approach (BFS Topological Sort - Kahn's Algorithm):
     * - Build graph with adjacency list and in-degree array
     * - Add all courses with in-degree 0 to a queue
     * - While the queue is not empty:
     *     - Remove one course, mark it as completed
     *     - Decrease in-degree of its neighbors
     *     - If a neighbor’s in-degree becomes 0, add it to queue
     * - If the number of completed courses equals numCourses, return true
     *   otherwise, a cycle exists → return false
     *
     * Time: O(V + E) — V = numCourses, E = total prerequisites
     * Space: O(V + E)
     */
    public boolean canFinish2(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> graph = new HashMap<>();
        int completed = 0;
        int[] inDegree = new int[numCourses];

        for(int[] curr : prerequisites) {
            int from = curr[1];
            int to = curr[0];
            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
            inDegree[curr[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {
            int course = queue.poll();
            completed++;

            for(int to : graph.getOrDefault(course, new ArrayList<>())) {
                inDegree[to]--;
                if(inDegree[to] == 0) {
                    queue.add(to);
                }
            }
        }

        return completed == numCourses;
    }


    /**
     * LeetCode 207 - Course Schedule
     * https://leetcode.com/problems/course-schedule/
     *
     * Approach (DFS with cycle detection):
     * - Model the course prerequisites as a directed graph (adjacency list)
     * - Use a visited array with 3 states:
     *     - 0 = unvisited
     *     - 1 = visiting (currently in the DFS call stack)
     *     - 2 = visited (fully explored and safe)
     * - Perform DFS for each course:
     *     - If a course is currently being visited and we reach it again (visited == 1), a cycle is detected → return false
     *     - If a course has been visited before (visited == 2), skip it
     *     - Otherwise, recursively DFS all of its neighbors
     * - If no cycle is found in any DFS path, return true
     *
     * Time: O(V + E), where V = numCourses and E = total prerequisites
     * Space: O(V + E), for graph storage and visited state array
     */
    class Solution1 {
        public boolean canFinish(int numCourses, int[][] prerequisites) {

            Map<Integer, List<Integer>> graph = new HashMap<>();

            for(int[] curr : prerequisites) {
                int from = curr[1];
                int to = curr[0];
                graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
            }

            int[] visited = new int[numCourses];

            for(int i = 0; i < numCourses; i++) {
                if(!dfs(i, graph, visited)) {
                    return false;
                }
            }

            return true;

        }

        public boolean dfs(int course, Map<Integer, List<Integer>> graph, int[] visited) {
            if(visited[course] == 1) return false;
            if(visited[course] == 2) return true;

            visited[course] = 1;

            for(int neighbor : graph.getOrDefault(course, new ArrayList<>())) {
                if(!dfs(neighbor, graph, visited)) {
                    return false;
                }
            }

            visited[course] = 2;
            return true;
        }
    }

}
