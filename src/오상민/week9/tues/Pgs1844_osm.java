/**
 * 게임 맵 최단거리
 */

import java.util.*;

class Solution {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    boolean[][] visited;
    int rowLen;
    int colLen;

    class Pair {
        int x;
        int y;
        int count;

        public Pair(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public int solution(int[][] maps) {
        rowLen = maps.length;
        colLen = maps[0].length;
        visited = new boolean[rowLen][colLen];
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(0, 0, 1));
        visited[0][0] = true;

        while (!que.isEmpty()) {
            Pair pair = que.remove();
            if (pair.x == rowLen - 1 && pair.y == colLen - 1) {
                return pair.count;
            }
            for (int i = 0; i < 4; i++) {
                int nextX = pair.x + dx[i];
                int nextY = pair.y + dy[i];
                if (nextX >= 0 && nextX < rowLen && nextY >= 0 && nextY < colLen && maps[nextX][nextY] == 1) {
                    if (!visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        que.offer(new Pair(nextX, nextY, pair.count + 1));
                    }
                }
            }
        }
        return -1;
    }
}
