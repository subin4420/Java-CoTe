package algorithm.week9;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class 미로탈출 {
    public static int[] dx = {0, -1, 0, 1};
    public static int[] dy = {1, 0, -1, 0};
    public static String[][] Miro;
    public static int n;
    public static int m;

    public static void main(String[] args) {
        String[] maps = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"}  ;
        System.out.println(Solution(maps));
    }
    public static int Solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();

        Miro = new String[n][m];
        int[] start = new int[2];
        int[] labor = new int[2];

        for(int i = 0; i < maps.length; i++) {
            String[] tmp = maps[i].split("");

            for(int j = 0; j < tmp.length; j++) {
                Miro[i][j] = tmp[j];

                if(Miro[i][j].equals("S")) {
                    start = new int[]{i,j};
                }
                if(Miro[i][j].equals("L")) {
                    labor = new int[]{i,j};
                }
            }
        }

        int distStart = bfs(start, "L"); // 출발점 -> 레버 까지의 최단경로 저장
        int distLabor = bfs(labor, "E"); // 레버 -> 출구 까지의 최단경로 저장

        if(distStart == -1 || distLabor == -1 ) { // 두 경로 중 하나라도 도달할 수 없는 경우
            return -1;
        }

        return distStart + distLabor; // (출발점 -> 레버) + (레버 -> 출구)
    }

    public static int bfs(int[] start, String word) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{start[0], start[1], 0});

        boolean[][] visited = new boolean[n][m];
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];

            if (Miro[x][y].equals(word)) {
                return dist;
            }

            for (int i = 0; i < 4; i++) {
                int nX = x + dx[i];
                int nY = y + dy[i];

                if (nX >= 0 && nY >= 0 && nX < n && nY < m) {
                    if (!visited[nX][nY] && !Miro[nX][nY].equals("X")) {
                        visited[nX][nY] = true;
                        queue.add(new int[]{nX, nY, dist + 1});
                    }
                }
            }
        }
        return -1; // 목표에 도달할 수 없을 경우
    }
}
