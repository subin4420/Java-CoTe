package algorithm.week9;

import java.util.ArrayDeque;
import java.util.Queue;

public class 게임맵최단거리 {
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};
    public static boolean[][] visited; // 방문 여부
    public static Queue<int[]> queue; // bfs 탐색을 위한 큐

    public static void main(String[] args) {
        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        System.out.println(solution(maps));
    }

    public static int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        visited = new boolean[n][m];
        queue = new ArrayDeque<>();

        return bfs(maps, n, m);
    }

    public static int bfs(int[][] maps, int n, int m) {
        queue.add(new int[]{0, 0, 1}); // 시작점 추가
        visited[0][0] = true; // 시작점 방문 체크

        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];

            // 도착점에 도착 -> 거리 반환
            if (x == n - 1 && y == m - 1) {
                return dist;
            }

            // 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위 내에 있고, 벽이 아니며, 이동할 수 있는 곳이라면 dist + 1 추가
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && maps[nx][ny] == 1) {
                    if (!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny, dist + 1});
                    }
                }
            }
        }

        return -1; // 도착점에 도달할 수 없는 경우
    }
}
