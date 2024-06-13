import java.util.*;

public class ex002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N]; //N개의 점수를 담을 배열 생성
        long max = 0, sum = 0; //타입을 long으로?

        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            A[i] = a;
            if (max < a) { //입력받은 숫자가 max보다 크다면 변경
                max = a;
            }
            sum += a;
        }
//        float newAvg = sum * 100 / max / N;
        double newAvg = sum * 100.0 / max / N;
        System.out.println(newAvg);
    }
}

