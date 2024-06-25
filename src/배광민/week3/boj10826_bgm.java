import java.util.Scanner;

public class boj10826_bgm {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
//        int[] dp = new int[N + 1];
//        dp[0] = 0;
//        dp[1] = 1;
//        for (int i = 2; i < dp.length; i++) {
//            dp[i] = dp[i-1] + dp[i-2];
//        }
//        System.out.println(dp[N]);
        for (int i = 1; i <= N; i++) {
            System.out.println(call(i) + " ");
        }
    }

    public static int call(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return call(n - 1) + call(n - 2);
    }
}