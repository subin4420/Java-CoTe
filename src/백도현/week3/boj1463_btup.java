import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int[] dp = new int[x+1];
        for (int i = 2; i <= x; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 6 == 0) dp[i] = Math.min(dp[i / 3], dp[i / 2]) + 1;
            else if (i % 3 == 0) dp[i] = Math.min(dp[i / 3] + 1, dp[i]);
            else if (i % 2 == 0) dp[i] = Math.min(dp[i / 2] + 1, dp[i]);
        }
        System.out.println(dp[x]);
        br.close();
    }
}