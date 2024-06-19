import java.util.Arrays;
import java.util.Scanner;

public class boj2294_bgm_success {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();  // 동전 종류
        int K = sc.nextInt();  // target
        int[] value = new int[N];  // 가치 배열

        for (int i = 0; i < N; i++) {
            value[i] = sc.nextInt();
        }

        // DP 배열 초기화. DP[i]는 금액 i를 만들기 위해 필요한 최소 동전 개수.
        int[] dp = new int[K + 1];
        Arrays.fill(dp, K + 1);  // K + 1로 초기화 (최대값으로 설정, 불가능한 경우를 대비)
        dp[0] = 0;  // 0원을 만들기 위해 필요한 동전 개수는 0개

        for (int i = 0; i < N; i++) {  // 각 동전 가치에 대해
            for (int j = value[i]; j <= K; j++) {  // 현재 동전 가치부터 목표 금액까지
                dp[j] = Math.min(dp[j], dp[j - value[i]] + 1);
            }
        }

        System.out.println(dp[K]);
    }
}
