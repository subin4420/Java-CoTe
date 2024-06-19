import java.util.Scanner;

public class boj11722_bgm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] seq = new int[N];
        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            seq[i] = sc.nextInt();
        }
        dp[0] = 1;

        for (int i = 1; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (seq[i] < seq[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(dp[i], max);
        }
        System.out.println(max);
    }
}
