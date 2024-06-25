import java.util.Arrays;
import java.util.Scanner;

public class boj11057_hj {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] dp = new long[n+1][10];

        // n=1일때는 모든 수의 오르막 길이 1개
        Arrays.fill(dp[1], 1);

        //i=n, j=0~9
        for(int i = 2; i <= n; i++){
            for(int j=0; j < 10; j++) {
                for(int k=0; k<=j; k++){
                    dp[i][j] += dp[i-1][k];
                    dp[i][j] %= 10007;
                }
            }

        }

        int sum = 0;
        for(int i=0; i<10; i++) {
            sum += dp[n][i];
        }
        System.out.println(sum%1007);

    }
}
