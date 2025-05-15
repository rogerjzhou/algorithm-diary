package P0073_SetMatrixZeros;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeros {

    /**
     * LeetCode 73 - Set Matrix Zeroes
     * https://leetcode.com/problems/set-matrix-zeroes/
     *
     * Approach (Space Optimized O(1)):
     * - Use the first row and first column of the matrix itself as markers
     * - First, check if the first row and first column contain any zeros
     *     - Store this information in two boolean flags
     * - Then, for the rest of the matrix:
     *     - If matrix[i][j] == 0, mark matrix[i][0] and matrix[0][j] as 0
     * - In a second pass, use these markers to set cells to 0 (excluding first row and column)
     * - Finally, if needed, set the first row and/or first column to 0 based on the flags
     *
     * Time: O(m * n), where m = rows and n = columns
     * Space: O(1), constant space (excluding the input matrix)
     */
    class Solution {
        public void setZeroes(int[][] matrix) {
            boolean firstRowZero = false;
            boolean firstColumnZero = false;

            // Check first row
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[0][j] == 0) {
                    firstRowZero = true;
                }
            }

            // Check first column
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][0] == 0) {
                    firstColumnZero = true;
                }
            }

            // Use first row and column to mark zero rows/columns
            for (int i = 1; i < matrix.length; i++) {
                for (int j = 1; j < matrix[0].length; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }

            // Zero out cells based on marks (excluding first row and column)
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[0][j] == 0) {
                    for (int i = 1; i < matrix.length; i++) {
                        matrix[i][j] = 0;
                    }
                }
            }

            for (int i = 1; i < matrix.length; i++) {
                if (matrix[i][0] == 0) {
                    for (int j = 1; j < matrix[0].length; j++) {
                        matrix[i][j] = 0;
                    }
                }
            }

            // Zero out first row if needed
            if (firstRowZero) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[0][j] = 0;
                }
            }

            // Zero out first column if needed
            if (firstColumnZero) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][0] = 0;
                }
            }
        }
    }


    /**
     * LeetCode 73 - Set Matrix Zeroes
     * https://leetcode.com/problems/set-matrix-zeroes/
     *
     * Approach:
     * - Use two sets to record the row and column indices that need to be zeroed
     * - First pass: scan the matrix and record all (i, j) positions where matrix[i][j] == 0
     *     - Add i to row set, j to column set
     * - Second pass:
     *     - For each recorded row, set entire row to 0
     *     - For each recorded column, set entire column to 0
     *
     * Time: O(m * n), where m = number of rows, n = number of columns
     * Space: O(m + n) for storing rows and columns to be zeroed
     */
    class Solution2 {
        public void setZeroes(int[][] matrix) {
            Set<Integer> row = new HashSet<>();
            Set<Integer> column = new HashSet<>();

            // First pass: find zero positions
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == 0) {
                        row.add(i);
                        column.add(j);
                    }
                }
            }

            // Zero out rows
            for (int i : row) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }

            // Zero out columns
            for (int j : column) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

}
