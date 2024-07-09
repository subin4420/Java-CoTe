package algorithm.week6;

import java.util.Scanner;

public class boj2293_hj {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(); // 동전의 종류 수
        int k = sc.nextInt();   // 만들어야 할 금액

        int[] coin = new int[num];
        for (int i = 0; i < num; i++) {
            coin[i] = sc.nextInt(); // 동전의 가치 배열
        }

        int[] dp = new int[k + 1];
        dp[0] = 1; // 0원을 만드는 방법은 1가지 (아무 동전도 사용하지 않는 경우)

        for (int i = 0; i < num; i++) { // 각 동전의 가치에 대해
            for (int j = coin[i]; j <= k; j++) { // j원을 만드는 방법을 구함
                if (j >= coin[i]) {
                    dp[j] += dp[j - coin[i]]; // j원을 만드는 방법은 (j - coin[i])원을 만드는 방법에 coin[i]원을 추가하는 방법을 더한 것
                }
            }
        }

        System.out.println(dp[k]); // k원을 만드는 방법의 수 출력
    }
}
