/**
 * Word-Search
 */
class Solution {
    boolean[][] visited;
    int length;
    int xLength;
    int yLength;
    String tmp;
    HashSet<String> answer;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    void dfs(String current, int curX, int curY, char[][] board) {
        // 유효성 검사
        if (curX < 0 || curY < 0 || curX >= xLength || curY >= yLength) {
            return;
        }
        if (visited[curX][curY]) {
            return;
        }

        current += board[curX][curY];
        if (!tmp.startsWith(current)) {
            return;
        }

        if (current.equals(tmp)) {
            answer.add(current);
            System.out.println(current);
            return;
        }

        visited[curX][curY] = true;
        for (int i = 0; i < 4; i++) {
            int nextX = curX + dx[i];
            int nextY = curY + dy[i];
            dfs(current, nextX, nextY, board);
        }
        visited[curX][curY] = false;
    }

    public boolean exist(char[][] board, String word) {
        length = word.length();
        answer = new HashSet<>();
        xLength = board.length;
        yLength = board[0].length;
        tmp = word;
        visited = new boolean[xLength][yLength];

        for (int i = 0; i < xLength; i++) {
            for (int j = 0; j < yLength; j++) {
                if (board[i][j] == word.charAt(0)) {
                    dfs("", i, j, board);
                }
            }
        }
        return answer.contains(word);
    }
}