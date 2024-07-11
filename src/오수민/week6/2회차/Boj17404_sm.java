package week6.thu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj17404 {
    private static final int INF = 1_000 * 1_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N+1][3];
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

//        int N = 8;
//        int[][]arr = {
//                {0,0,0},
//                {71, 39, 44},
//                {32, 83, 55},
//                {51, 37, 63},
//                {89, 29, 100},
//                {83, 58, 11},
//                {65, 13, 15},
//                {47, 25, 29},
//                {60, 66, 19}
//        };


        int[][] d = new int[N+1][3];
        int answer = INF;

        for(int f=0;f<3;f++){
            for(int c=0;c<3;c++){
                if(c==f){
                    d[1][c] = arr[1][c];
                }
                else{
                    d[1][c] = INF;
                }
            }
            for(int i=2;i<=N;i++){
                d[i][0] = Math.min(d[i-1][1],d[i-1][2]) + arr[i][0];
                d[i][1] = Math.min(d[i-1][0],d[i-1][2]) + arr[i][1];
                d[i][2] = Math.min(d[i-1][0],d[i-1][1]) + arr[i][2];
            }

            for(int c=0;c<3;c++){
                if(c==f) continue;
                answer = Math.min(answer,d[N][c]);
            }
        }
        System.out.println(answer);
    }
}
