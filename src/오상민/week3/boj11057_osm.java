package Algorithm.silver1;

import java.util.Arrays;
import java.util.Scanner;

public class boj11057_osm {
    static int dp[] = {1, 1, 1, 1, 1, 1, 1, 1, 1};
    static int result = 10; //끝자리 0일때
    static int mod = 10007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int digit = scanner.nextInt();
        if (digit == 1) {
            System.out.println(result);
        } else {
            for (int i = 1; i < digit; i++) {
                asc();
            }
            System.out.println(result % mod);
        }
    }

    public static void asc() {
        for (int i = 0; i < dp.length; i++) {
            int tmp = 0;
            for (int j = i; j < dp.length; j++) {
                tmp += dp[j];
            }
            dp[i] = tmp%mod;
        }
        result += Arrays.stream(dp).sum();
    }
}