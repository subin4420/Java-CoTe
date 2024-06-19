import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(minOperations(n));
    }

    public static int minOperations(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 0;  // 1은 이미 1이므로 연산이 필요x

        for (int i = 2; i <= n; i++) {
            // 1을 빼는 경우
            dp[i] = dp[i - 1] + 1;
            // 2로
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            // 3로
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }
        return dp[n];
    }
}
