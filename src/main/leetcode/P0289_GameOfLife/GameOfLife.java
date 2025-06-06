package P0289_GameOfLife;

/**
 * LeetCode 289 - Game of Life
 * https://leetcode.com/problems/game-of-life/
 *
 * Approach:
 * - Create a copy of the original board to preserve current states
 * - For each cell, count its live neighbors using the 8 surrounding directions
 * - Apply the Game of Life rules:
 *   - Live cell with <2 or >3 neighbors → dies
 *   - Live cell with 2 or 3 neighbors → lives
 *   - Dead cell with exactly 3 neighbors → becomes alive
 * - Copy updated states back to the original board
 *
 * Time: O(m * n)
 * Space: O(m * n)
 */
public class GameOfLife {

    class Solution {
        public void gameOfLife(int[][] board) {

            int[][] copy = new int[board.length][board[0].length];
            for(int i = 0; i < board.length; i++) {
                for(int j = 0; j < board[0].length; j++) {
                    nextState(i, j, board, copy);
                }
            }

            for(int i = 0; i < board.length; i++) {
                for(int j = 0; j < board[0].length; j++) {
                    board[i][j] = copy[i][j];
                }
            }
        }


        public void nextState(int i, int j, int[][] board, int[][] copy) {

            int oneCounter = 0;
            int n = board.length;
            int m = board[0].length;

            int[][] dirs = {
                    {-1, -1}, {-1, 0}, {-1, 1},
                    {0, -1},           {0, 1},
                    {1, -1},  {1, 0},  {1, 1}
            };

            for(int[] dir : dirs) {
                int newR = i + dir[0];
                int newC = j + dir[1];

                if(newR >= 0 && newC < m && newR < n && newC >= 0) {
                    oneCounter += board[newR][newC];
                }
            }

            if(board[i][j] == 1) {
                if(oneCounter < 2 || oneCounter > 3) {
                    copy[i][j] = 0;
                } else {
                    copy[i][j] = 1;
                }
            }

            if(board[i][j] == 0) {
                if(oneCounter == 3) {
                    copy[i][j] = 1;
                }
            }
        }

        public void nextState1(int i, int j, int[][] board, int[][] copy) {

            int oneCounter = 0;
            int n = board.length;
            int m = board[0].length;

            oneCounter += j + 1 < m ? board[i][j + 1] : 0;
            oneCounter += (i + 1 < n && j + 1 < m) ? board[i + 1][j + 1] : 0;
            oneCounter += (i + 1 < n) ? board[i + 1][j] : 0;
            oneCounter += (i + 1 < n && j - 1 >= 0) ? board[i + 1][j - 1] : 0;
            oneCounter += (j - 1 >= 0) ? board[i][j - 1] : 0;
            oneCounter += (i - 1 >= 0 && j - 1 >= 0) ? board[i - 1][j - 1] : 0;
            oneCounter += (i - 1 >= 0) ? board[i - 1][j] : 0;
            oneCounter += (i - 1 >= 0 && j + 1 < m) ? board[i - 1][j + 1] : 0;

            if(board[i][j] == 1) {
                if(oneCounter < 2 || oneCounter > 3) {
                    copy[i][j] = 0;
                } else {
                    copy[i][j] = 1;
                }
            }

            if(board[i][j] == 0) {
                if(oneCounter == 3) {
                    copy[i][j] = 1;
                }
            }
        }

    }

}
