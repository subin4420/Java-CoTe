import java.util.Scanner;

public class Boj11057 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

//        n= 1 -> 0~9  => 총 10개
//        n=2 -> 00,11,.... => 55개
//        00
//        10
//        11
//        0 0 0
//        1 0 0
//        1 1 0
//        1 1 1

        int cnt = 0;

        int[][] dp = new int[1001][10]; //왜 초기에 1001할당?
//        길이가 i이면서 j로 끝나는 경우
//        dp[i][j] = dp[i-1][j] + dp[i][j-1]
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1; //1행은 모두 1임
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
//                    첫 열은 무조건 1
                    dp[i][0] = 1;
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                dp[i][j] %= 10007;
            }
        }

        int res = 0;
        for (int i = 0; i < 10; i++) {
            res = res + dp[n][i];
        }
        System.out.println(res);
    }
}
