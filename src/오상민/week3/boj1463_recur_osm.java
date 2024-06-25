package Algorithm.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1463_recur_osm {

    static Integer[] dp;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new Integer[n + 1];
        dp[0] = dp[1] = 0;
        System.out.println(one(n));
    }

    public static int one(int n) {
        if (dp[n] == null) {
            if (n % 3 == 0 && n % 2 == 0) {
                return dp[n] = Math.min(one(n / 3), one(n / 2)) + 1;
            } else if (n % 3 == 0) {
                return dp[n] = Math.min(one(n / 3), one(n - 1)) + 1;
            } else if (n % 2 == 0) {
                return dp[n] = Math.min(one(n / 2), one(n - 1)) + 1;
            } else {
                return dp[n] = one(n - 1) + 1;
            }
        } else {
            return dp[n];
        }
    }
}

