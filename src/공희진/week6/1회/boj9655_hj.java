package algorithm.week6;

import java.util.Scanner;
//돌 게임
public class boj9655_hj {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        //dp[]값이 홀수 -상근 , 짝수 - 창영 이김
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 1;

        for (int i = 4; i <= num; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 3]) + 1; //1개 가져갔을경우, 3개 가져갔을 경우의  최소
        }
        if (dp[num] % 2 == 0) {
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }


    }
}
