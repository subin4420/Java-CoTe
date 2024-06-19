import java.util.Arrays;
import java.util.Scanner;

public class boj2294_bgm {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] value= new int[N];
        int cnt = 0;
        int remaining = K;

        for (int i = 0; i < N; i++) {
            value[i] = sc.nextInt();
        }
        Arrays.sort(value);

        for (int i = N - 1; i >= 0; i--) {
            if (value[i] <= remaining) {
                cnt += remaining / value[i];  // 해당 가치 동전의 최대 사용 개수 추가
                remaining = remaining % value[i];  // 남은 금액 갱신
            }
            if (remaining == 0) {
                break;  // 목표 금액을 맞추면 종료
            }
        }

        System.out.println(cnt);

    }
}
