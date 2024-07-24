package BaeJoon;

import java.util.Scanner;

public class boj17404 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] cost = new int[n][3];
        int inf = 1000 * 1000;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < 3; j++){
                cost[i][j] = sc.nextInt();
            }
        }

        int result = inf;

        // 첫 번째 집의 색깔을 각각 R, G, B로 고정
        for (int firstColor = 0; firstColor < 3; firstColor++) {
            int[][] dp = new int[n][3];

            // DP 배열 초기화
            for (int i = 0; i < 3; i++) {
                if (i == firstColor) {
                    dp[0][i] = cost[0][i];
                } else {
                    dp[0][i] = inf;
                }
            }

            // DP 갱신
            for (int i = 1; i < n; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2];
            }

            // 마지막 집의 색깔이 첫 번째 집의 색깔과 같지 않도록 결과 계산
            for (int lastColor = 0; lastColor < 3; lastColor++) {
                if (lastColor != firstColor) {
                    result = Math.min(result, dp[n - 1][lastColor]);
                }
            }
        }

        System.out.println(result);
    }
}
