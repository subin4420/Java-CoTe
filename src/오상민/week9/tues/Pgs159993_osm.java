/**
 * 미로 탈출
 */

import java.util.*;

class Solution {
    boolean[][] visited1;
    boolean[][] visited2;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    int startX, startY;
    int leverX, leverY;
    int endX, endY;

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

    public int solution(String[] maps) {
        visited1 = new boolean[maps.length][maps[0].length()];
        visited2 = new boolean[maps.length][maps[0].length()];
        char[][] tmp = new char[maps.length][maps[0].length()];
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if (maps[i].charAt(j) == 'S') {
                    startX = i;
                    startY = j;
                }
                if (maps[i].charAt(j) == 'L') {
                    leverX = i;
                    leverY = j;
                }
                if (maps[i].charAt(j) == 'E') {
                    endX = i;
                    endY = j;
                }
                tmp[i][j] = maps[i].charAt(j);
            }
        }

        int answer = 0;
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(startX, startY, 0));
        visited1[startX][startY] = true;
        boolean isLever = false;
        while (!que.isEmpty()) {
            Pair pair = que.remove();

            if (!isLever && pair.x == leverX && pair.y == leverY) {
                isLever = true;
                que.clear();
                que.add(new Pair(leverX, leverY, pair.count));
                visited2[leverX][leverY] = true;
                continue;
            }
            if (isLever && pair.x == endX && pair.y == endY) {
                return pair.count;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = pair.x + dx[i];
                int nextY = pair.y + dy[i];
                if (nextX >= 0 && nextY >= 0 && nextX < maps.length && nextY < maps[0].length() && tmp[nextX][nextY] != 'X') {
                    if (!isLever) {
                        if (!visited1[nextX][nextY]) {
                            visited1[nextX][nextY] = true;
                            que.add(new Pair(nextX, nextY, pair.count + 1));
                        }
                    } else {
                        if (!visited2[nextX][nextY]) {
                            visited2[nextX][nextY] = true;
                            que.add(new Pair(nextX, nextY, pair.count + 1));
                        }
                    }
                }
            }
        }
        return -1;
    }
}