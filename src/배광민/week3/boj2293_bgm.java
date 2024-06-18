import java.util.Scanner;

public class boj2293_bgm {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] value = new int[N];
        int[] dp = new int[K];
        dp[0] = 1;

        for (int i = 0; i < N; i++) {
            value[i] = sc.nextInt();
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < K; j++) {
                //?
                dp[j] += dp[j - value[i - 1]];
            }
        }

        System.out.println(dp[K - 1]);
    }
}
