package ct_0801;

import java.util.ArrayDeque;
import java.util.Queue;

public class pgs81302_sb {
    class Solution {
        // 메인 솔루션 함수, 각 대기실의 거리두기 준수 여부를 반환합니다.
        public int[] solution(String[][] places) {
            int[] answer = new int[places.length];
            // 각 대기실 별로 거리두기 준수 여부를 확인합니다.
            for (int i = 0; i < answer.length; i++) {
                if (check(places[i])) answer[i] = 1; // 거리두기가 잘 지켜지고 있다면 1을 할당
                else answer[i] = 0; // 거리두기 위반이 있다면 0을 할당
            }
            return answer;
        }

        // 한 대기실 내에서 모든 자리를 검사하여 거리두기 준수 여부를 확인합니다.
        boolean check(String[] place) {
            for (int r = 0; r < 5; r++) {
                for (int c = 0; c < 5; c++) {
                    // 응시자(P) 위치마다 BFS를 수행합니다.
                    if (place[r].charAt(c) == 'P') {
                        if (!bfs(r, c, place)) return false; // BFS 결과 거리두기 위반이 있다면 false 반환
                    }
                }
            }
            return true; // 모든 P에 대해 문제가 없으면 true 반환
        }

        // BFS를 이용하여 주어진 위치에서 거리두기를 확인합니다.
        boolean bfs(int r, int c, String[] place) {
            final int[] dr = {  0,  1,  0, -1 };
            final int[] dc = {  1,  0, -1,  0 };
            boolean[][] visited = new boolean[5][5];
            Queue<int[]> queue = new ArrayDeque<>();
            queue.add(new int[]{ r, c, 0 });
            visited[r][c] = true;

            while (!queue.isEmpty()) {
                int[] cur = queue.remove();
                if (cur[2] >= 2) continue; // 거리가 2 이상이면 더 이상 확인할 필요 없음

                for (int i = 0; i < 4; i++) {
                    int nr = cur[0] + dr[i];
                    int nc = cur[1] + dc[i];
                    int ndist = cur[2] + 1;
                    if (inRange(nr, nc) && place[nr].charAt(nc) != 'X') { // 범위 내에 있고, 파티션('X')이 아닌 경우
                        if (!visited[nr][nc]) {
                            // 다른 'P'를 만나면 즉시 false 반환
                            if (place[nr].charAt(nc) == 'P') return false;
                            queue.add(new int[]{ nr, nc, ndist });
                            visited[nr][nc] = true;
                        }
                    }
                }
            }
            return true; // 검사 범위 내에 문제가 없으면 true 반환
        }

        // 주어진 좌표가 5x5 그리드 내에 있는지 확인합니다.
        boolean inRange(int r, int c) {
            return (r >= 0) && (r < 5) && (c >= 0) && (c < 5);
        }
    }
}
