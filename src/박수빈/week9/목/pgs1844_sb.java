package ct_0801;
import java.util.*;

public class pgs1844_sb {
    class Solution {
        int rowlen;
        int collen;
        boolean[][] visited;
        int[] dr = {1,-1,0,0};
        int[] dc = {0,0,1,-1};
        int cnt;

        public int solution(int[][] maps) {
            int answer = 0;
            rowlen = maps.length;
            collen = maps[0].length;
            visited = new boolean[rowlen][collen];
            //시작점이 1일 경우
            if(maps[0][0] == 1){
                return bfs(0,0,maps);
            }
            //아닐 경우 -1 리턴
            return -1;
        }


        public int bfs(int r, int c, int[][] maps){
            Queue<int[]> queue = new LinkedList<>();
            //시작점 (행, 열, 거리) 넣어주고
            queue.add(new int[]{r,c,1});
            //방문 체크
            visited[r][c] = true;
            // 큐 빌때까지 실행
            while(!queue.isEmpty()){
                int[] cur = queue.poll();
                for(int i=0;i<4;i++){
                    int nr = cur[0]+dr[i];
                    int nc = cur[1]+dc[i];
                    int dist = cur[2] + 1;
                    //마지막 끝에 왔는지 체크
                    if(nr == rowlen-1 && nc == collen -1 ){
                        return dist;
                    }
                    // 유효한 위치인지(맵 밖인지 아닌지) 체크
                    if(0<=nr && nr<rowlen && 0<=nc && nc<collen ){
                        //방문했나 체크 + 경로인지(1 or 0) 체크
                        if(maps[nr][nc] == 1 && !visited[nr][nc]){
                            //큐에 넣을 자격이 있는 것들 넣기
                            queue.add(new int[]{nr,nc,dist});
                            //넣었다는건 방문했다는 것..
                            visited[nr][nc] = true;
                        }
                    }
                }


            }
            //끝까지 경로가 없을 경우 => 큐를 비웠는데도 도착 못함 -1 반환
            return -1;
        }
    }
}
