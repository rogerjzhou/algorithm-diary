package P1219_PathWithMaxGold;

/**
 * LeetCode 1219 - Path with Maximum Gold
 *
 * Tags: Backtracking, DFS, Matrix
 *
 * Approach:
 *  - Try starting DFS from each cell that contains gold (> 0).
 *  - At each step, collect the current cell’s gold, mark it as visited by setting it to 0.
 *  - Recursively explore all four directions (up, down, left, right) without revisiting any cell.
 *  - After exploring, backtrack by restoring the original gold value.
 *  - Keep track of the maximum gold collected across all paths.
 *
 * Time Complexity: O(m * n * 3^(m * n))
 *   - In the worst case, DFS starts from every cell and explores all possible paths.
 *   - Each move has up to 3 valid directions (excluding the direction it came from).
 *
 * Space Complexity: O(m * n)
 *   - Due to the recursion call stack (maximum depth is m * n), and in-place marking avoids extra memory.
 */
public class PathWithMaxGold {
    class Solution {

        int max = 0;

        public int getMaximumGold(int[][] grid) {

            for(int i = 0; i < grid.length; i++) {
                for(int j = 0; j < grid[0].length; j++) {
                    if(grid[i][j] > 0) {
                        backtracking(i, j, grid, 0);
                    }
                }
            }
            return max;
        }

        public void backtracking(int row, int column, int[][] grid, int currMax) {
            if(row < 0 || row == grid.length || column < 0 || column == grid[0].length || grid[row][column] == 0) {
                return;
            }

            int goldHere = grid[row][column];
            currMax += goldHere;
            max = Math.max(max, currMax);
            grid[row][column] = 0;

            backtracking(row + 1, column, grid, currMax);
            backtracking(row - 1, column, grid, currMax);
            backtracking(row, column + 1, grid, currMax);
            backtracking(row, column - 1, grid, currMax);

            grid[row][column] = goldHere;
        }
    }
}
