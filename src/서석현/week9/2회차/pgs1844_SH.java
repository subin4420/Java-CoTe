//게임 맵 최단거리
package Programmers;

import java.util.*;

public class pgs1844_SH {
    static class Solution {
        static int[] dr = {1, -1, 0, 0};
        static int[] dc = {0, 0, -1, 1};

        public int solution(int[][] maps) {
            int rowLength = maps.length;
            int colLength = maps[0].length;
            boolean[][] visited = new boolean[rowLength][colLength];

            return bfs(maps, visited, rowLength, colLength);
        }

        public int bfs(int[][] maps, boolean[][] visited, int rowLength, int colLength) {
            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{0, 0, 1}); // 시작 위치와 초기 거리 1을 큐에 넣음
            visited[0][0] = true;

            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int curRow = cur[0];
                int curCol = cur[1];
                int curDist = cur[2];

                // 도착지점에 도달한 경우, 현재까지의 거리를 반환
                if (curRow == rowLength - 1 && curCol == colLength - 1) {
                    return curDist;
                }

                // 상하좌우로 이동
                for (int i = 0; i < 4; i++) {
                    int nextRow = curRow + dr[i];
                    int nextCol = curCol + dc[i];

                    // 이동 가능한 유효한 위치인지 확인
                    if (nextRow >= 0 && nextRow < rowLength && nextCol >= 0 && nextCol < colLength) {
                        if (maps[nextRow][nextCol] == 1 && !visited[nextRow][nextCol]) {
                            q.offer(new int[]{nextRow, nextCol, curDist + 1});
                            visited[nextRow][nextCol] = true;
                        }
                    }
                }
            }

            // 도착지점에 도달할 수 없는 경우 -1 반환
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] maps = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };
        System.out.println(solution.solution(maps));
    }
}
