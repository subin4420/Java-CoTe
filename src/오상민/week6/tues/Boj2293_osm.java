import java.util.Scanner;

public class Boj2293_osm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] coin = new int[n];
        int dp[] = new int[k + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            coin[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                if (j - coin[i] >= 0) {
                    dp[j] += dp[j - coin[i]];
                }
            }
        }
        System.out.println(dp[k]);
    }
}
