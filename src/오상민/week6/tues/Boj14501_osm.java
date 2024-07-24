import java.util.Arrays;
import java.util.Scanner;

public class Boj14501_osm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] day = new int[n];
        int[] price = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            day[i] = sc.nextInt();
            price[i] = sc.nextInt();
        }
        if (day[0] > n) {
            dp[0] = 0;
        } else {
            dp[0] = price[0];

        }
        for (int i = 1; i < n; i++) {
            int tmp = 0;
            if (day[i] + i <= n) {
                for (int j = i - 1; j >= 0; j--) {
                    if (day[j] + j <= i && tmp < dp[j]) {
                        tmp = dp[j];
                    }
                }
                dp[i] = tmp + price[i];
            } else {
                dp[i] = 0;
            }
        }
        int answer = Arrays.stream(dp).max().getAsInt();
        System.out.println(answer);
    }
}
