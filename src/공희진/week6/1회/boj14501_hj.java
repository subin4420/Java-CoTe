package algorithm.week6;

import java.util.Scanner;
//퇴사
public class boj14501_hj {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int[] day = new int[num + 1];
        int[] pay = new int[num + 1];
        int[] dp = new int[num + 2];

        for (int i = 1; i <= num; i++) {
            day[i] = sc.nextInt();
            pay[i] = sc.nextInt();
        }

        for(int i = num; i > 0; i--) {
            if(i + day[i] > num + 1) { // 상담이 끝나는 날이 퇴사일을 넘어가면
                dp[i] = dp[i + 1]; // 상담을 진행할 수 없으므로 이전날의 최대값
            } else {
                // 일하지 않았을 때 = dp[i + 1]
                // 일 했을 때 총 벌 수 있는 금액 = pay[i] + dp[i + day[i]]
                dp[i] = Math.max(dp[i + 1], pay[i] + dp[i + day[i]]);
            }
        }

        System.out.println(dp[1]);


    }
}
