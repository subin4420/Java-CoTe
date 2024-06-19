import java.util.Scanner;

public class boj11055_bgm {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc. nextInt();
        int[] seq = new int[N];
        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            seq[i] = sc.nextInt();
        }

        dp[0] = seq[0];
        int max = dp[0];

        for (int i = 1; i < N; i++) {
            dp[i] = seq[i];
            for (int j= 0; j < i; j++) {
                if(seq[i] > seq[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + seq[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);

    }
}
