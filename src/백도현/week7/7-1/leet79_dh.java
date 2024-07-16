import java.util.*;
class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static int n, m;
    static boolean match;

    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;
        match = false;
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(i, j, board, word, board[i][j] + "");
                if (match) return match;
            }
        }
        return match;
    }

    public void dfs(int x, int y, char[][] board, String word, String now) {
        if (now.length() == word.length()) {
            if (now.equals(word)) {
                match = true;
            }
            return;
        }
        if (board[x][y] == word.charAt(now.length() - 1)) {
            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (isRange(nx, ny) && !visited[nx][ny]) {
                    dfs(nx, ny, board, word, now + board[nx][ny]);
                }
            }
            visited[x][y] = false;
        } 
        return;
    }

    public boolean isRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}