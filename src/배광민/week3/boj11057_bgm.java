import java.util.Scanner;

public class boj11057_bgm {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //구해야 하는 수의 길이

        //길이가 1 -> 모두 자기 자신이라서 오르막 수는 1개씩
        int[][] dp = new int[N+1][10];
        for (int i = 0; i < 10; i++) {
            dp[0][i] = 1;
        }

        // 길이가 i일 때 오르막 수 구하기
        for (int i = 1; i < N + 1; i++) {
            // 끝 자리가 j 일 때 오르막 수 구하기
            for (int j = 0; j < 10; j++) {
                // 이전 길이(i-1)일 때 끝 자리가 j보다 작은 모든 수들을 더하기
                for (int k = j; k < 10; k++) {
                    dp[i][j] += dp[i-1][k];
                    dp[i][j] %= 10007;
                }
            }
        }

        System.out.println(dp[N][0] % 10007);
    }
}
