package cote0709;

import java.util.Scanner;

public class Q4{
    //동전//완
    /*
    3 10
    1
    2
    5
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] coin = new int[n];
        int[] dp = new int[k+1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            coin[i] = sc.nextInt();
        }
        for(int i = 1; i < n; i++){
            dp[i] = 0;
        }
        for (int j = 0; j < n; j++) {
            for(int i = 0; i <= k; i++){
                if(i-coin[j] <0) continue;
                dp[i] += dp[i - coin[j]];
                //System.out.println(dp[i]);

            }
        }
        System.out.println(dp[k]);




    }
}
