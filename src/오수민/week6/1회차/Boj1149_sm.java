package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1149_sm {
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

//        int N = 3;
//        int[][]arr = {
//                {0,0,0},
//                {26, 40, 83},
//                {49, 60, 57},
//                {13, 89, 99}
//        };

        int[][] d = new int[N+1][3];
        for(int i=1;i<=N;i++){
            d[i][0] = Math.min(d[i-1][1],d[i-1][2]) + arr[i][0];
            d[i][1] = Math.min(d[i-1][0],d[i-1][2]) + arr[i][1];
            d[i][2] = Math.min(d[i-1][0],d[i-1][1]) + arr[i][2];
        }
        System.out.println(Arrays.stream(d[N]).min().getAsInt());
    }
}
