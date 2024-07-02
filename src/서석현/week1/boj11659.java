import java.util.Scanner;

public class boj11659 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 첫 번째 줄 입력: N (수열의 길이), M (구간 합을 구해야 하는 횟수)
        int N = sc.nextInt();
        int M = sc.nextInt();

        // 수열 입력 받기
        int[] array = new int[N + 1]; // 1-based index를 사용하기 위해 크기를 N+1로 설정
        for (int i = 1; i <= N; i++) {
            array[i] = sc.nextInt();
        }

        // 누적 합 배열 만들기
        int[] addSum = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            addSum[i] = addSum[i - 1] + array[i];
        }

        // 구간 합 계산하기
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int sum = addSum[end] - addSum[start - 1];
            sb.append(sum).append("\n");
        }

        // 결과 출력
        System.out.print(sb.toString());

        // Scanner 닫기
        sc.close();
    }
}
