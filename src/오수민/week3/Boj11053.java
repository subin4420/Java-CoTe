package DP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.max;

//DP사용하기
//1. DFS/BFS로 풀 수 있지만 경우의 수가 너무 많은 문제
//2. 경우의 수들에 중복적인 연산이 많은 경우
//뒤로 돌아가지 않을 방법을 찾아보기

public class Boj11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        Arrays.fill(dp,1);

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

//        가장 긴 증가하는 부분 수열의 길이 출력 -> dp문제
//        10 20 10 30 20 50 => 4
//        3 1 2 => 1
//        2 4 2 1 8 6 2 3 1 7 6 1 5 6

        for(int i=1;i<N;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    dp[i] = max(dp[i],dp[j]+1); //해당 값에 도달하기까지의 최대 길이로 업데이트
                }
            }
        }
        
        //dp배열중에 가장 큰 값이 답임
        Arrays.sort(dp);
        int cnt = dp[N-1];
        System.out.println(cnt);
    }
}