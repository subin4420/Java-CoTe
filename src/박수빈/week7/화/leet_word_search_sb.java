package algo0712;

public class word_search {
    class Solution {
        public boolean exist(char[][] board, String word) {
            int m = board.length,
                    n = board[0].length;
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    //보드판을 순회
                    //해당 글자가 word의 첫글자와 드라면 넘어가
                    if (board[r][c] != word.charAt(0)) continue;
                    //첫글자와 동일하면 주변 확인해봐야댐 현재 문자 버퍼에 넣고
                    char buffer = board[r][c];
                    board[r][c] = '.';
                    //bt실행
                    if (backtrack(board, r, c, word, 0)) return true;
                    //해당 문자로 시작하는 걸로 만들 수 없었다 원래대로
                    board[r][c] = buffer;
                }
            }
            return false;
        }
        //4방 탐색을 위한 배열 2개
        int[] dr = { 1, 0, -1, 0 };
        int[] dc = { 0, 1, 0, -1 };

        boolean backtrack(char[][] board, int r, int c, String word, int count) {
            //cnt +1 이 word길이와 같다 == 다 만들었따.
            if (count + 1 == word.length()) return true;

            int m = board.length,
                n = board[0].length;

            for (int i = 0; i < 4; i++) {
                //4방향 이동 해보기
                int nr = r + dr[i],
                    nc = c + dc[i];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    //주변 체크 넘어가는 거없나
                    if (board[nr][nc] == word.charAt(count+1)) {
                        //word 0번째 통과 1 2 3 .. 시도
                        char buffer = board[nr][nc];
                        board[nr][nc] = '.';
                        if (backtrack(board, nr, nc, word, count+1)) return true;
                        board[nr][nc] = buffer;
                    }
                }
            }
            return false;
        }
    }
}
