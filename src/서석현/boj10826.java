package BaeJoon;

import java.math.BigInteger;
import java.util.Scanner;

public class boj10826 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        BigInteger result = fibo(n);
        System.out.print(result);
    }

    public static BigInteger fibo(int n) {

        if(n == 0) return BigInteger.ZERO;
        //반복문
        BigInteger[] dp = new BigInteger[n+1];
        dp[0] = BigInteger.ZERO;
        dp[1] = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2]);
        }

        return dp[n];

        //재귀함수
//        if(n == 0) return 0;
//        if(n == 1) return 1;
//        return fibo(n - 1) + fibo(n - 2);
    }
}
