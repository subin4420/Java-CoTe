//거리두기 확인하기
package Programmers;

import java.util.*;

public class pgs81302_SH {
    static class Solution {
        static int[] dr = {-1, 1, 0, 0};
        static int[] dc = {0, 0, -1, 1};

        public int[] solution(String[][] places) {
            int[] answer = new int[places.length];

            for (int i = 0; i < places.length; i++) {
                if (checkPlace(places[i])) {
                    answer[i] = 1; // 거리두기 준수
                } else {
                    answer[i] = 0; // 거리두기 미준수
                }
            }

            return answer;
        }

        // 특정 대기실의 거리두기 규칙을 확인
        public boolean checkPlace(String[] place) {
            for (int r = 0; r < 5; r++) {
                for (int c = 0; c < 5; c++) {
                    if (place[r].charAt(c) == 'P') { // 사람 발견
                        if (!bfs(place, r, c)) {
                            return false; // 거리두기 미준수
                        }
                    }
                }
            }
            return true; // 거리두기 준수
        }

        // BFS를 사용해 거리 2 이내의 다른 사람(P)이 있는지 확인
        public boolean bfs(String[] place, int startRow, int startCol) {
            Queue<int[]> queue = new LinkedList<>();
            boolean[][] visited = new boolean[5][5];

            queue.offer(new int[]{startRow, startCol, 0});
            visited[startRow][startCol] = true;

            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                int curRow = cur[0];
                int curCol = cur[1];
                int curDist = cur[2];

                // 맨해튼 거리가 2 이상이면 더 이상 탐색하지 않음
                if (curDist >= 2) continue;

                for (int i = 0; i < 4; i++) {
                    int nextRow = curRow + dr[i];
                    int nextCol = curCol + dc[i];

                    if (nextRow >= 0 && nextRow < 5 && nextCol >= 0 && nextCol < 5) {
                        if (visited[nextRow][nextCol]) continue;

                        if (place[nextRow].charAt(nextCol) == 'P') {
                            return false; // 거리 2 이내에 다른 사람이 있는 경우
                        }

                        if (place[nextRow].charAt(nextCol) == 'O') {
                            queue.offer(new int[]{nextRow, nextCol, curDist + 1});
                            visited[nextRow][nextCol] = true;
                        }
                    }
                }
            }

            return true; // 거리두기 규칙을 준수함
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[][] places = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOXP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };

        int[] result = solution.solution(places);
        System.out.println(Arrays.toString(result));
    }
}