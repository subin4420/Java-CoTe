import java.util.Scanner;

public class Boj1149_osm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] r = new int[n];
        int[] g = new int[n];
        int[] b = new int[n];
        int dp[][] = new int[3][n];

        for (int i = 0; i < n; i++) {
            r[i] = scanner.nextInt();
            g[i] = scanner.nextInt();
            b[i] = scanner.nextInt();
        }

        dp[0][0] = r[0];
        dp[1][0] = g[0];
        dp[2][0] = b[0];

        for (int i = 1; i < n; i++) {
            dp[0][i] = Math.min(dp[1][i - 1], dp[2][i - 1]) + r[i];
            dp[1][i] = Math.min(dp[0][i - 1], dp[2][i - 1]) + g[i];
            dp[2][i] = Math.min(dp[0][i - 1], dp[1][i - 1]) + b[i];
        }
        System.out.println(Math.min(dp[0][n - 1], Math.min(dp[1][n - 1], dp[2][n - 1])));
    }
}
