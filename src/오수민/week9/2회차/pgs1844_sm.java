package algo5.게임맵;

import java.util.ArrayDeque;
import java.util.Queue;

public class pgs1844_sm {
    //동서남북
    int[] dr = {0,0,1,-1};
    int[] dc = {1,-1,0,0};
    int rowLen, colLen;
    public int solution(int[][] maps) {
        rowLen = maps.length;
        colLen = maps[0].length;

        boolean[][] visited = new boolean[rowLen][colLen];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0,0,1});
        visited[0][0] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            int dist = cur[2];

            if(r==rowLen-1 && c==colLen-1) return dist;

            for(int i=0;i<4;i++){
                int nr = r+dr[i];
                int nc = c+dc[i];
                if(0<=nr&&nr<rowLen&&0<=nc&&nc<colLen&&maps[nr][nc]==1&&!visited[nr][nc]){
                    queue.offer(new int[]{nr,nc,dist+1});
                    visited[nr][nc] = true;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        pgs1844_sm solution = new pgs1844_sm();
        System.out.println(
                solution.solution(new int[][]{
                        {1, 0, 1, 1, 1},
                        {1, 0, 1, 0, 1},
                        {1, 0, 1, 1, 1},
                        {1, 1, 1, 0, 1},
                        {0, 0, 0, 0, 1}
                })
        );

    }
}
