package algorithm.week6;

import java.util.Scanner;
//RGB거리
public class boj1149_hj {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int[][] home = new int[num][3];
        int[][] dp = new int[num][3];

        for(int i = 0; i < home.length; i++) {
            for(int j = 0; j < home[i].length; j++) {
                home[i][j] = sc.nextInt();
            }
        }

        dp[0][0] = home[0][0];
        dp[0][1] = home[0][1];
        dp[0][2] = home[0][2];

        for(int i = 1; i < num; i++ ) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + home[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + home[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + home[i][2];
        }

        int result = Math.min(dp[num-1][0], Math.min(dp[num-1][1], dp[num-1][2]));
        System.out.println(result);
    }
}
