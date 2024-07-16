package algorithm.week7;

public class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length,
                n = board[0].length;
        //✅ board를 순회하며, 현재 위치(i, j)의 글자가 word의 0번째 글자와 같은지 검사한다.
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] != word.charAt(0)) continue;
                //✅ 현재 위치의 글자를 buffer에 저장하고, '.'으로 교체한다.
                char buffer = board[r][c];
                board[r][c] = '.';
                //✅ 재귀함수를 호출한다.
                //✅ 재귀함수의 반환값이 true라면, true를 반환한다.
                if (backtrack(board, r, c, word, 0)) return true;
                //✅ 아니라면, 현재 위치의 글자를 buffer로 대체한다.
                board[r][c] = buffer;
            }
        }
        return false;
    }

    int[] dr = { 1, 0, -1, 0 };
    int[] dc = { 0, 1, 0, -1 };

    boolean backtrack(char[][] board, int r, int c, String word, int count) {
        //✅ count + 1이 word 길이와 동일하다면, true를 반환한다. (base case)
        if (count + 1 == word.length()) return true;

        int m = board.length,
                n = board[0].length;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i],
                    nc = c + dc[i];
            if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                //✅ 다음 위치의 글자가 word의 count + 1번째 문자와 같다면,
                if (board[nr][nc] == word.charAt(count+1)) {
                    //✅ 다음 위치의 글자를 buffer에 저장하고, '.'으로 교체한다.
                    char buffer = board[nr][nc];
                    board[nr][nc] = '.';
                    //✅ 재귀함수를 호출한다.
                    //✅ 재귀함수의 반환값이 true라면, true를 반환한다.
                    if (backtrack(board, nr, nc, word, count+1)) return true;
                    //✅ 아니라면, 현재 위치의 글자를 buffer로 대체한다.
                    board[nr][nc] = buffer;
                }
            }
        }
        return false;
    }
}
