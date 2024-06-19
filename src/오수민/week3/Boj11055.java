package DP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        int[] dp = new int[N];

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = arr[i];
        }

//        합이 가장 큰 수열 출력하기
        for(int i=1;i<N;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    dp[i] = Math.max(dp[i],dp[j]+arr[i]);
                }
            }
        }

        Arrays.sort(dp);
        System.out.println(dp[N-1]);
    }
}
