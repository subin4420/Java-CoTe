package Algorithm.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1463_osm {

    static int dp[];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        dp[0] = dp[1] = 0;
        System.out.println(one(n));
    }

    public static int one(int n) {
        for (int i = 2; i <= n; i++) {
            if (i % 3 == 0 && i % 2 == 0) {
                dp[i] = Math.min(dp[i / 3], dp[i / 2]) + 1;
            } else if (i % 3 == 0) {
                dp[i] = Math.min(dp[i / 3], dp[i - 1]) + 1;
            } else if (i % 2 == 0) {
                dp[i] = Math.min(dp[i / 2], dp[i - 1]) + 1;
            } else {
                dp[i] = dp[i - 1] + 1;
            }
        }
        return dp[n];
    }
}

