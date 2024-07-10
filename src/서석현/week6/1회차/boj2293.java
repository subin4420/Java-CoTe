package BaeJoon;

import java.util.Scanner;

public class boj2293 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] coin = new int[n];

        // 동전의 종류를 저장할 배열과 DP 배열을 선언
        int[] arr = new int[n + 1]; // 1-based index 사용
        int[] dp = new int[k + 1];
        dp[0] = 1;  // 초기화: 목표 금액이 0인 경우는 1가지 (동전을 사용하지 않는 경우)

        // 동전의 종류를 입력받고 DP 배열을 업데이트
        for(int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt(); // 동전의 종류 입력
            for (int j = arr[i]; j <= k; j++) {
                dp[j] += dp[j - arr[i]]; // DP 업데이트
            }
        }

        System.out.println(dp[k]);
    }
}
