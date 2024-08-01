package ct_0801;

import java.util.LinkedList;
import java.util.Queue;

public class pgs159993_sb2 {

    class Solution {
        public int solution(String[] maps) {
            int n = maps.length;
            int m = maps[0].length();
            char[][] maze = new char[n][m];
            int[] start = new int[2];
            int[] lever = new int[2];
            int[] end = new int[2];


            //String to char Array
            //and save the checkpoint to r and c
            for (int r = 0; r < n; r++) {
                maze[r] = maps[r].toCharArray();
                for (int c = 0; c < m; c++) {
                    if(maze[r][c] == 'L') {
                        lever[0] = r;
                        lever[1] = c;
                    }
                    else if(maze[r][c] == 'S') {
                        start[0] = r;
                        start[1] = c;
                    }
                    else if(maze[r][c] == 'E') {
                        end[0] = r;
                        end[1] = c;
                    }
                }
            }

            int toLever = bfs(maze,start,lever,n,m);
            if(toLever == -1) return -1;
            int toEnd = bfs(maze,lever,end,n,m);
            if(toEnd == -1) return -1;




            return toLever + toEnd;
        }

        private int bfs(char[][] maze, int[] start, int[] target, int n, int m) {
            Queue<int[]> queue = new LinkedList<>();
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};
            boolean[][] visited = new boolean[n][m];
            //시작지점을 큐에 넣고 시작하기위해(거리 추적을 위해 count도 넣어서 시작은 0)
            queue.add(new int[]{start[0],start[1],0});
            visited[start[0]][start[1]] = true;
            //예약하기 시작
            while(!queue.isEmpty()) {
                //r, c, cnt
                int[] cur = queue.poll();
                int r = cur[0];
                int c = cur[1];
                int dist = cur[2];
                //목표(레버일 수도 있고 도착지일 수도)도착함
                if(r == target[0] && c == target[1]) {
                    return dist;
                }
                //아니면 주변 이동시키기(조건에 맞다면)
                for(int i=0;i<4;i++) {
                    int nr = r + dx[i];
                    int nc = c + dy[i];
                    int newDist = dist + 1;
                    //갔더니 맵밖이 아니고 && 장애물도 아닐 경우 큐에 넣기
                    if(nr>=0&&nr<n && nc>=0&&nc<m && maze[nr][nc] != 'X' ){
                        if(!visited[nr][nc]) {
                            queue.add(new int[]{nr,nc,newDist});
                            visited[nr][nc] = true;
                        }

                    }
                }
            }
            //다 찾아봤는데 안나와 그럼 레버든 탈출구가 없어
            return -1;
        }
    }

}
