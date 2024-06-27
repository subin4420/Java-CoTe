package BaeJoon;

import java.util.Scanner;

public class boj11055 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] seq = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            seq[i] = sc.nextInt();
            dp[i] = seq[i];
        }


        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(seq[j] < seq[i]){
                    dp[i] = Math.max(dp[i], dp[j] + seq[i]);
                }
            }
        }


        int max = 0;
        for (int i = 0; i < n; i++) {
            max = dp[i] > max ? dp[i] : max;
        }
        System.out.println(max);
    }
}
