package algorithm.graph;

public class N_Queen {
    public class Solution {
        public int solution(int n) {
            boolean[][] board = new boolean[n][n];

            return placeQueens(board, 0, n);  //✅ 퀸을 놓을 수 있는 개수를 리턴한다.
        }

        int placeQueens(boolean[][] board, int row, int n) {  //✅ 백트래킹을 활용하여 열마다 퀸을 하나씩 놓는다.
            if (row == n) return 1; //✅ 퀸을 n개 골랐다면 1을 반환한다.

            int count = 0;
            for (int col = 0; col < n; col++) {
                if (checkBoard(board, row, col, n)) {  //✅ 퀸을 놓을 수 있는 경우에만 탐색을 진행한다.
                    board[row][col] = true;
                    count += placeQueens(board, row + 1, n);
                    board[row][col] = false;
                }
            }
            return count;
        }

        boolean checkBoard(boolean[][] board, int row, int col, int n) {
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
}
