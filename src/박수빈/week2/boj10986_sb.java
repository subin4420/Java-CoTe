import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 스캐너 정의
        Scanner sc = new Scanner(System.in);

        // 과목수 N과 나누는 수 M 입력
        int N = sc.nextInt();
        int M = sc.nextInt();

        // 배열 정의
        int[] arr = new int[N];
        // 첫 번째 코드에서는 int[] sum을 사용했지만, 여기서는 long[] sum 사용
        long[] sum = new long[N];
        // 첫 번째 코드에서는 int[] cnt를 사용했지만, 여기서는 long[] cnt 사용
        long[] cnt = new long[M];
        // 결과를 저장할 변수
        long result = 0;

        // 배열 입력 및 부분합 계산
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            if (i != 0)
                sum[i] = (sum[i - 1] + arr[i]) % M;  // 부분합 계산 후 M으로 나눈 나머지
            else
                sum[i] = arr[i] % M;
        }

        // 부분합의 나머지가 0인 경우와 cnt 배열 채우기
        for (int i = 0; i < N; i++) {
            if (sum[i] == 0) {
                result++;  // 부분합이 M으로 나누어 떨어지는 경우 결과 증가
            }
            // 첫 번째 코드에서는 int를 사용했지만, 여기서는 long 타입으로 형 변환 필요
            cnt[(int)sum[i]]++;
        }

        // cnt 배열을 통해 결과 계산
        for (int i = 0; i < M; i++) {
            if (cnt[i] > 1) {
                // 조합 계산: cnt[i] 중 2개를 뽑는 경우의 수
                result = result + (cnt[i] * (cnt[i] - 1) / 2);
            }
        }

        // 최종 결과 출력
        System.out.println(result);
    }
}
