package algo5.거리두기;

public class pgs81302_sm {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        //각 대기실 별로 거리두기 준수 여부 확인
        for (int i = 0; i < answer.length; i++) {
            if (check(places[i])) {
                answer[i] = 1;
            }
        }
        return answer;
    }

    boolean check(String[] place){
        //5*5로 고정
        for(int r=0;r<5;r++){
            for(int c=0;c<5;c++){
                //응시자 위치 마다 dfs수행
                if(place[r].charAt(c)=='P'){
                    if(!dfs(r,c,place,new boolean[5][5],0)) return false;
                }
            }
        }
        return true;
    }

    boolean dfs(int r, int c, String[] place, boolean[][] visited, int depth){
        //거리두기 2이상이면 잘 지킨거임
        if(depth>=2) return true;

        visited[r][c] = true;
        for(int i=0;i<4;i++){ //4가지 방향
            int nr = r+dr[i];
            int nc = c+dc[i];
            //r,c가 범위 안에있고 벽이 아닌경우에
            if(inRange(nr,nc)&&place[nr].charAt(nc)!='X'){
                if(!visited[nr][nc]){
                    //거리두기 준수 안하면 false
                    if(place[nr].charAt(nc)=='P'){ return false; }
                    if(!dfs(nr,nc,place,visited,depth+1)){ return false; }
                }
            }
        }
        return true;
    }

    boolean inRange(int r, int c){
        return (r>=0)&&(r<5)&&(c>=0)&&(c<5);
    }
}
