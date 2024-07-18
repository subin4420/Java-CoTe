class leet_WordSearch_bgm {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int k = 0; k < m; k++) {
            for (int l = 0; l < n; l++) {
                if (board[k][l] != word.charAt(0)) continue;

                char buffer = board[k][l];
                board[k][l] = '.';

                if (backtrack(board, k, l, word, 0)) return true;

                board[k][l] = buffer;
            }
        }
        return false;
    }

    int[] dr = {1 ,0, -1, 0};
    int[] dc = {0, 1, 0, -1};

    boolean backtrack(char[][] board, int k, int l, String word, int count) {
        if (count + 1 == word.length()) return true;

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < 4; i++) {
            int nr = m + dr[i];
            int nc = n + dc[i];
            if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                if (board[nr][nc] == word.charAt(count + 1)) {
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