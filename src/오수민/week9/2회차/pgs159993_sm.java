package algo5.미로탈출;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class pgs159993_sm {
    //상하좌우
    int[] dr = {0,0,1,-1};
    int[] dc = {1,-1,0,0};
    int rowLen, colLen;
    public int solution(String[] maps) {
        int answer = 0;

        rowLen = maps.length;
        colLen = maps[0].length();
        boolean[][] visited = new boolean[rowLen][colLen];
        Queue<int[]> queue = new ArrayDeque<>();

        int[] start = new int[2];
        int[] lever= new int[2];
        int[] exit= new int[2];


        for(int r=0;r<rowLen;r++){
            for(int c=0;c<colLen;c++){
                if(maps[r].charAt(c)=='S'){
                    start = new int[]{r,c};
                }else if(maps[r].charAt(c)=='L'){
                    lever = new int[]{r,c};
                }else if(maps[r].charAt(c)=='E'){
                    exit = new int[]{r,c};
                }
            }
        }

        int toLever = bfs(start,lever,maps);
        if(toLever==-1){ return - 1; }

        int toExit = bfs(lever, exit, maps);
        if(toExit==-1){ return -1; }

        return toLever + toExit;
    }

    public int bfs(int[] start, int[] target, String[] maps){
        boolean[][] visited = new boolean[rowLen][colLen];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{start[0],start[1],0});
        visited[start[0]][start[1]] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            int d = cur[2];

            if(r==target[0]&&c==target[1]){ return d; } //타켓에 도달하면 return

            for(int i=0;i<4;i++){
                int nr = r+dr[i];
                int nc = c+dc[i];

                if(nr>=0&&nc>=0&&nr<rowLen&&nc<colLen&&maps[nr].charAt(nc) != 'X'&&!visited[nr][nc]){
                    queue.offer(new int[]{nr,nc,d+1});
                    visited[nr][nc] = true;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        pgs159993_sm solution = new pgs159993_sm();
        System.out.println(solution.solution(new String[]{
                "SOOOL",
                "XXXXO",
                "OOOOO",
                "OXXXX",
                "OOOOE"
        }));
    }
}
