package BaeJoon;

import java.util.Scanner;

public class boj11057 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int mod = 10007;

        int[][] dp = new int[n+1][10];

        for (int i=0; i<=9; i++) {
            dp[1][i] = 1;
        }

        for (int i=1; i<=n; i++) {
            dp[i][0] = 1;
            for (int j=1; j<=9; j++) {
                dp[i][j] = (dp[i-1][j] + dp[i][j-1])%mod;
            }
        }

        int result = 0;
        for (int i=0; i<=9; i++) {
            result = (result += dp[n][i])%mod;
        }

        System.out.println(result);

        }
}
