import java.util.*;

public class pgs87694_bgm {
    class Solution {

        static int[][] arr = new int[101][101];
        static boolean[][] visit = new boolean[101][101];
        static int[] dx = {-1, 0, 1, 0};
        static int[] dy = {0, 1, 0, -1};

        public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

            draw(rectangle);

            return bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
        }

        public int bfs(int x, int y, int a, int b) {

            Queue<Pair> que = new ArrayDeque<>();

            que.add(new Pair(x, y, 0));
            visit[y][x] = true;

            while (!que.isEmpty()) {
                Pair curr = que.remove();


                if (curr.x == a && curr.y == b)
                    return curr.w / 2;


                for (int i = 0 ; i < 4; i++) {
                    int nextX = curr.x + dx[i];
                    int nextY = curr.y + dy[i];

                    if (nextX >= 1 && nextX <= 100 && nextY >= 1 && nextY <= 100
                            && !visit[nextY][nextX] && arr[nextY][nextX] == 1) {

                        que.add(new Pair(nextX, nextY, curr.w + 1));
                        visit[nextY][nextX] = true;

                    }
                }
            }

            return -1;

        }

        /* 이 부분 코드 참조
        public void draw(int[][] rectangle) {

            for (int i = 0; i < rectangle.length; i++) {
                int x1 = rectangle[i][0] * 2;
                int y1 = rectangle[i][1] * 2;

                int x2 = rectangle[i][2] * 2;
                int y2 = rectangle[i][3] * 2;

                for (int j = x1; j <= x2; j++) {
                    for (int k = y1; k <= y2; k++) {
                        if (j == x1 || j == x2 || k == y1 || k == y2) {
                            if (arr[k][j] == 2)
                                continue;
                            arr[k][j] = 1;
                        } else {
                            arr[k][j] = 2;
                        }
                    }
                }
            }
        }
         */

        public class Pair {
            int x, y, w;

            public Pair(int x, int y, int w) {
                this.x = x;
                this.y = y;
                this.w = w;
            }
        }

    }
}
