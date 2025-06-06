package P0079_WordSearch;

/**
 * LeetCode 79 - Word Search
 * https://leetcode.com/problems/word-search/
 *
 * Approach (Backtracking + DFS):
 * - Iterate over every cell in the board as a potential starting point.
 * - If the current cell matches word.charAt(0), launch a DFS from that cell.
 * - In dfs(i, j, idx):
 *     1. If idx == word.length(), we have matched all characters; return true.
 *     2. Temporarily mark board[i][j] as visited by setting visited[i][j] = true.
 *     3. For each of the four directions (down, right, up, left):
 *     4. If none of the four directions succeed, backtrack by setting visited[i][j] = false and return false.
 *
 * Time: O(N * 4^L), where N = number of cells (board.length * board[0].length) and L = word.length()
 * Space: O(L), due to recursion depth and visited array (visited is O(N), but only one call stack of depth ≤ L)
 */
public class WordSearch {

    class Solution {

        public boolean exist(char[][] board, String word) {

            boolean[][] visited = new boolean[board.length][board[0].length];

            for(int i = 0; i < board.length; i++) {
                for(int j = 0; j < board[0].length; j++) {
                    if(found(i, j, board, word, 0, visited)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean found(int i, int j, char[][] board, String word, int idx, boolean[][] visited) {

            if(idx == word.length()) {
                return true;
            }

            if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j]
                    || (board[i][j] != word.charAt(idx))) {
                return false;
            }

            visited[i][j] = true;

            if(found(i + 1, j, board, word, idx + 1, visited) ||
                    found(i, j + 1, board, word, idx + 1, visited) ||
                    found(i - 1, j, board, word, idx + 1, visited) ||
                    found(i, j - 1, board, word, idx + 1, visited)) {
                return true;
            }
            visited[i][j] = false;
            return false;
        }
    }
}
