package algorithm.week6;

import java.util.Scanner;

public class boj17404_hj {
    /*
    1번 집의 색은 2번, N번 집의 색과 같지 않아야 한다.
    N번 집의 색은 N-1번, 1번 집의 색과 같지 않아야 한다.
    i(2 ≤ i ≤ N-1)번 집의 색은 i-1, i+1번 집의 색과 같지 않아야 한다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] list = new int[n + 1][3];  // 페인트 칠 비용 입력
        int[][] dp = new int[n + 1][3];    // dp[k][j] -> 집 k를 j색으로 칠할 때의 최소 비용
        int[] paint = new int[3];          // 첫 집의 색깔에 따른 최소 비용 저장

        // 페인트 칠 비용 입력 받기
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 3; j++) {
                list[i][j] = sc.nextInt();
            }
        }

        // 첫 집에 각 색을 칠할 경우의 최소 비용 계산
        for (int i = 0; i < 3; i++) {    // 첫 집에 i색을 칠함
            for (int j = 0; j < 3; j++) { // 색깔 준비
                if (i == j) {
                    dp[1][j] = list[1][j]; // 첫 집에 i색을 칠함
                } else {
                    dp[1][j] = 1001; // 나머지 색은 고려하지 않음
                }
            }

            // 두 번째 집부터 색칠
            for (int k = 2; k <= n; k++) {
                dp[k][0] = Math.min(dp[k - 1][1], dp[k - 1][2]) + list[k][0]; // 빨강으로 칠할 때 최소 비용
                dp[k][1] = Math.min(dp[k - 1][0], dp[k - 1][2]) + list[k][1]; // 초록으로 칠할 때 최소 비용
                dp[k][2] = Math.min(dp[k - 1][0], dp[k - 1][1]) + list[k][2]; // 파랑으로 칠할 때 최소 비용

                if (k == n) { // 마지막 집의 경우
                    if (i == 0) { // 첫 집을 빨강으로 칠했을 때
                        paint[i] = Math.min(dp[n][1], dp[n][2]); // 마지막 집은 초록 또는 파랑
                    } else if (i == 1) { // 첫 집을 초록으로 칠했을 때
                        paint[i] = Math.min(dp[n][0], dp[n][2]); // 마지막 집은 빨강 또는 파랑
                    } else if (i == 2) { // 첫 집을 파랑으로 칠했을 때
                        paint[i] = Math.min(dp[n][0], dp[n][1]); // 마지막 집은 빨강 또는 초록
                    }
                }
            }
        }

        // 세 가지 경우 중 최소 비용을 출력
        System.out.print(Math.min(paint[0], Math.min(paint[1], paint[2])));
    }
}