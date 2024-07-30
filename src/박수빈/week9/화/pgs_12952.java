package ct_0730;
//N-Queen


//DFS문제
//일단 퀸의 경우는 해당 row에 뒀다면 그 row에 다른 퀸 올 수 없다.
//첫 행부터 첫 열부터 끝 열까지 퀸을 놓을 경우로 dfs를 보낸다.
//해당 row에 놓는 순간. 해당 보드판 놓을 수 있다는 의미의 true로 바꾼다.(dfs의 가장 기본적인 visited배열 느낌)
//그 후 재귀로 다음row로 보낸다.
//이렇게 해당 row 의 모든 col에 퀸을 둔 경우로 재귀함수를 호출한다.
//해당row와 해당 col을 받은 다음재귀함수는 넘어온 row값에 1을 더한 row에서 col 0부터 n까지 퀸을 놓아본다..
//여기서 시간을 단축하기위해 해당열에 재귀를 보내기전에 그 윗 row들을 보며 해당 col에 놓을 수 있는지 확인한다.
//여기서 체크를 위로만 하는 이유는 아래에는 퀸이 없기 떄문
//해당 row에 놓을 수 있는 col로 가지들을 보낸다.
//row가 n과같아지면 끝까지갔다는뜻 1을반환단다.
//이렇게 돌아오기 시작하면 1에 다시 1을 더하고 반복하여 가능한경우만 count된다.



public class pgs_12952 {
    public class Solution {
        // n개의 퀸을 놓을 수 있는 방법의 수를 반환하는 메소드
        public int solution(int n) {
            // n x n 크기의 체스판을 초기화
            boolean[][] board = new boolean[n][n];
            // placeQueens 메소드를 호출하여 가능한 배치의 수를 반환
            return placeQueens(board, 0, n);
        }

        // 백트래킹을 사용하여 퀸을 놓는 메소드
        int placeQueens(boolean[][] board, int row, int n) {
            // 모든 퀸을 다 놓았다면 1을 반환
            if (row == n) return 1;

            int count = 0;
            // 현재 행의 각 열에 퀸을 놓을 수 있는지 확인
            for (int col = 0; col < n; col++) {
                if (checkBoard(board, row, col, n)) {
                    // 퀸을 놓을 수 있는 경우, 퀸을 놓고 다음 행으로 이동
                    board[row][col] = true;
                    count += placeQueens(board, row + 1, n);
                    // 퀸을 놓았던 자리를 원상태로 복구
                    board[row][col] = false;
                }
            }
            // 가능한 모든 배치의 수를 반환
            return count;
        }

        // 현재 위치에 퀸을 놓을 수 있는지 확인하는 메소드
        boolean checkBoard(boolean[][] board, int row, int col, int n) {
            // 같은 열에 다른 퀸이 있는지 확인
            for (int i = 0; i < row; i++) {
                if (board[i][col]) return false;
            }

            // 좌상단 대각선에 다른 퀸이 있는지 확인
            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
                if (board[i][j]) return false;
            }

            // 우상단 대각선에 다른 퀸이 있는지 확인
            for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
                if (board[i][j]) return false;
            }

            // 현재 위치에 퀸을 놓을 수 있는 경우
            return true;
        }
    }
}
