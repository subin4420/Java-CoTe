/**
 * N-Queen
 */

class Solution {
    boolean[][] board;

    int backtrack(int x, int n) {
        if (x == n) {
            return 1;
        }

        int count = 0;
        for (int col = 0; col < n; col++) {
            if (checkBoard(x, col, n)) {
                board[x][col] = true;
                count += backtrack(x + 1, n);
                board[x][col] = false;
            }
        }
        return count;
    }

    public int solution(int n) {
        board = new boolean[n][n];
        return backtrack(0, n);
    }

    boolean checkBoard(int row, int col, int n) {
        for (int i = 0; i < row; i++) {
            if (board[i][col]) return false;
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j]) return false;
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j]) return false;
        }

        return true;
    }
}