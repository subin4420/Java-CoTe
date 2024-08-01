//미로 탈출
package Programmers;

import java.util.*;

public class pgs159993_SH {
    static class Solution {
        static int[] dr = {-1, 1, 0, 0};
        static int[] dc = {0, 0, -1, 1};

        public int solution(String[] maps) {
            int rowLength = maps.length;
            int colLength = maps[0].length();
            char[][] grid = new char[rowLength][colLength];

            int[] start = new int[2];
            int[] lever = new int[2];
            int[] exit = new int[2];

            // 맵 초기화 및 S, L, E 위치 찾기
            for (int i = 0; i < rowLength; i++) {
                for (int j = 0; j < colLength; j++) {
                    grid[i][j] = maps[i].charAt(j);
                    if (grid[i][j] == 'S') {
                        start[0] = i;
                        start[1] = j;
                    } else if (grid[i][j] == 'L') {
                        lever[0] = i;
                        lever[1] = j;
                    } else if (grid[i][j] == 'E') {
                        exit[0] = i;
                        exit[1] = j;
                    }
                }
            }

            // 시작 -> 레버까지 거리
            int toLever = bfs(grid, start, lever, rowLength, colLength);
            if (toLever == -1) {
                return -1;
            }

            // 레버 -> 출구까지 거리
            int toExit = bfs(grid, lever, exit, rowLength, colLength);
            if (toExit == -1) {
                return -1;
            }

            // 전체 경로 합산
            return toLever + toExit;
        }

        // BFS 메서드
        public int bfs(char[][] grid, int[] start, int[] target, int rowLength, int colLength) {
            Queue<int[]> q = new LinkedList<>();
            boolean[][] visited = new boolean[rowLength][colLength];

            q.offer(new int[]{start[0], start[1], 0}); // 시작 위치와 거리 0을 큐에 넣음
            visited[start[0]][start[1]] = true;

            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int curRow = cur[0];
                int curCol = cur[1];
                int curDist = cur[2];

                // 목표 지점에 도달하면 현재까지의 거리를 반환
                if (curRow == target[0] && curCol == target[1]) {
                    return curDist;
                }

                // 상하좌우로 이동
                for (int i = 0; i < 4; i++) {
                    int nextRow = curRow + dr[i];
                    int nextCol = curCol + dc[i];

                    // 이동 가능한 유효한 위치인지 확인
                    if (nextRow >= 0 && nextRow < rowLength && nextCol >= 0 && nextCol < colLength) {
                        if (grid[nextRow][nextCol] != 'X' && !visited[nextRow][nextCol]) {
                            q.offer(new int[]{nextRow, nextCol, curDist + 1});
                            visited[nextRow][nextCol] = true;
                        }
                    }
                }
            }

            // 목표 지점에 도달할 수 없는 경우 -1 반환
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] maps = {
                "SOOOL",
                "XXXXO",
                "OOOOO",
                "OXXXX",
                "OOOOE"
        };
        System.out.println(solution.solution(maps));
    }
}