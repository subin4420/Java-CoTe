package cote_0711;

import java.util.Arrays;
import java.util.Scanner;

//RGB거리2
public class boj17404_sb {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][3];
        int[][] tem_arr = new int[n][3];

        int[][] dp = new int[n][3];
        int[] res = new int[3];
        // 비용 입력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                tem_arr[i][j] = arr[i][j];
            }
        }

// 0고정
        tem_arr[0][1] = 100000;
        tem_arr[0][2] = 100000;
        tem_arr[n-1][0] = 100000;
        dp[0][0] = tem_arr[0][0];
        dp[0][1] = tem_arr[0][1];
        dp[0][2] = tem_arr[0][2];

        for (int i = 1; i < n; i++) {
            dp[i][0] = tem_arr[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = tem_arr[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = tem_arr[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }
        Arrays.sort(dp[n-1]);
        res[0] = dp[n-1][0];
        tem_arr[0][1] = arr[0][1];
        tem_arr[0][2] = arr[0][2];

        tem_arr[n-1][0] = arr[n-1][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                tem_arr[i][j] = arr[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = 0;
            }
        }
        //1고정
        tem_arr[0][0] = 100000;
        tem_arr[0][2] = 100000;
        tem_arr[n-1][1] = 100000;

        dp[0][0] = tem_arr[0][0];
        dp[0][1] = tem_arr[0][1];
        dp[0][2] = tem_arr[0][2];

        for (int i = 1; i < n; i++) {
            dp[i][0] = tem_arr[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = tem_arr[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = tem_arr[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }
        Arrays.sort(dp[n-1]);
        res[1] = dp[n-1][0];
        tem_arr[0][0] = arr[0][0];
        tem_arr[0][2] = arr[0][2];

        tem_arr[n-1][1] = arr[n-1][1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                tem_arr[i][j] = arr[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = 0;
            }
        }
        //2고정
        tem_arr[0][0] = 100000;
        tem_arr[0][1] = 100000;
        tem_arr[n-1][2] = 100000;

        dp[0][0] = tem_arr[0][0];
        dp[0][1] = tem_arr[0][1];
        dp[0][2] = tem_arr[0][2];

        for (int i = 1; i < n; i++) {
            dp[i][0] = tem_arr[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = tem_arr[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = tem_arr[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }
        Arrays.sort(dp[n-1]);
        res[2] = dp[n-1][0];
        tem_arr[0][0] = arr[0][0];
        tem_arr[0][1] = arr[0][1];

        tem_arr[n-1][2] = arr[n-1][2];

        Arrays.sort(res);
        System.out.println(res[0]);

    }
}
