package cote0709;

import java.util.Scanner;

public class Q1 {
    //퇴사
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[N+1];
        int[] T = new int[N+1];
        int[] P = new int[N+1];
        for (int i = 1; i <= N; i++) {
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }
        for (int i = 1; i <=N; i++) {
            dp[i] = Math.max(dp[i],dp[i-1]);
            if(i+T[i]<=N+1)
                dp[i+T[i]-1] = Math.max(dp[i+T[i]-1],dp[i-1]+P[i]);
        }
        System.out.println(Math.max(dp[N], dp[N-1]));
    }
}
