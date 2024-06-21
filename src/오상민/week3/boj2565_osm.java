package Algorithm.gold5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class boj2565_osm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int dp[][] = new int[n][2];
        int len[] = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i][0] = scanner.nextInt();
            dp[i][1] = scanner.nextInt();
        }
        Arrays.sort(dp, Comparator.comparingInt((int[] o) -> o[0]));
        for (int i = 0; i < dp.length; i++) {
            len[i] = 1;
            for (int j = 0; j < i; j++) {
                if (dp[i][1] > dp[j][1] && len[i] < len[j] + 1) {
                    len[i] = len[j] + 1;
                }
            }
        }
        Arrays.sort(len);
        System.out.println(n - len[len.length - 1]);
    }
}
