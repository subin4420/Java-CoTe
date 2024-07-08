package kakao2020;

import java.util.Arrays;

public class Pgs118667_sm {
    public static void main(String[] args) {
        int[] queue1 = {3, 2, 7, 2};
        int[] queue2 = {4, 6, 5, 1};
        int answer = 0;

        int n = queue1.length;
        long[] merged = new long[n * 2];

        for (int i = 0; i < n; i++) {
            merged[i] = queue1[i];
        }
        for (int i = 0; i < n; i++) {
            merged[n + i] = queue2[i];
        }

        long q1Sum = Arrays.stream(queue1).sum();
        long q2Sum = Arrays.stream(queue2).sum();

        //모든 원소의 합이 홀수면 안됨
        //두 큐의 합이 같아질 수 없기 때문에
        if ((q1Sum + q2Sum) % 2 != 0) {
//            return -1;
        }

        long target = (q1Sum + q2Sum) / 2; //만들고자 하는 합

        //q1꺼
        int l1 = 0;
        int r1 = n - 1;

        //q2꺼
        int l2 = n;
        int r2 = n * 2 - 1;

        //배열 모두 탐색하면 종료
        //answer는 모두 탐색하는 경우 보다는 적어야함
        while (answer < 4 * n) {
            if (q1Sum < target) {
                r1 = (r1 + 1) % merged.length;
                l2 = (l2 + 1) % merged.length;
                q1Sum += merged[r1];
                q2Sum -= merged[r1];

                answer++;
            }
            if (q2Sum < target) {
                r2 = (r2 + 1) % merged.length;
                l1 = (l1 + 1) % merged.length;

                q2Sum += merged[r2];
                q1Sum -= merged[r2];

                answer++;
            }

            if(q1Sum == target && q2Sum == target) {
                break;
            }
        }
//        return q1Sum == q2Sum ? answer : -1;

    }
}
