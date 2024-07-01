package BaeJoon;

import java.util.Scanner;

public class boj11722 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] seq = new int[n];
        int[] dp = new int[n];
        int[] revSeq = new int[n];

        for (int i = 0; i < n; i++) {
            seq[i] = sc.nextInt();
        }

        for(int i = seq.length - 1, j = 0; i >= 0; i--, j++) {
            revSeq[j] = seq[i];
        }

        for(int i = 0; i < n; i++) {
            dp[i] = 1;

            for(int j = 0; j < n; j++) {
                if(revSeq[i] > revSeq[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j]+1;
                }
            }
        }

        int max = 0;
        for(int i = 0; i < n; i++) {
            max = dp[i] > max ? dp[i] : max;
        }

        System.out.println(max);
    }
}
