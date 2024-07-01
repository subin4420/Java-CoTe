package DP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.max;

public class Boj11722 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

//        가장 긴 감소하는 부분 수열
        int[] dp = new int[N];
        Arrays.fill(dp,1);
        for(int i=0;i<N;i++){
            for(int j=0;j<i;j++){
                if(arr[i]<arr[j]){
                    dp[i] = max(dp[i],dp[j]+1);
                }
            }
        }

        Arrays.sort(dp);
        System.out.println(dp[N-1]);
    }
}
