package algo0712;

import java.util.Scanner;

public class fatigue {
    int cnt;
    int oriK;
    boolean visited[];
    public int solution(int k, int[][] dungeons) {
        cnt = 0;
        oriK = k;
        visited = new boolean[dungeons.length];
        for (int i = 0; i < dungeons.length; i++) {
            visited[i] = false;
        }
        return  backtrack(k,dungeons,0);
    }

    //80	[[80,20],[50,40],[30,10]]


    public int backtrack(int cur_k, int[][] dungeons, int C) {
        if (cnt < C){
            cnt = C;
        }
        //재귀
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && cur_k>= dungeons[i][1]) {
                visited[i] = true;
                backtrack(cur_k - dungeons[i][1], dungeons,C+1);
                visited[i] = false;

                C=0;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = 80;
        fatigue f = new fatigue();
        int[][] dungeons = {{80,20},{50,40},{30,10}};

        System.out.println(f.solution(k,dungeons));


    }
}
