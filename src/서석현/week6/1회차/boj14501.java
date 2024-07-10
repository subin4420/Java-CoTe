package BaeJoon;

import java.util.Scanner;

public class boj14501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] t = new int[N + 1];
        int[] p = new int[N + 1];
        int[] dp = new int[N + 2];  //(N+2 크기, 경계 초과 방지용)

        for (int i = 1; i <= N; i++) {
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }

        // DP를 역순으로 계산
        for (int i = N; i > 0; i--) {
            // i번째 날에 상담을 할 수 있는 경우
            if (i + t[i] <= N + 1) {
                // 상담을 하지 않는 경우(dp[i + 1]) vs 상담을 하는 경우(P[i] + dp[i + T[i]]) 중 큰 값을 선택
                dp[i] = Math.max(dp[i + 1], p[i] + dp[i + t[i]]);
            } else {
                // 상담을 할 수 없는 경우 (퇴사일을 넘어가는 경우), 상담을 하지 않는 경우만 가능
                dp[i] = dp[i + 1];
            }
        }

        System.out.println(dp[1]);
    }
}
