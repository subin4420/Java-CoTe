package algorithm.week5;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//두 큐 합 같게 만들기
public class pgs118667_hj {
    public static void main(String[] args) {
        int[] queue1 = {1,1};
        int[] queue2 = {1,5};
        System.out.println(solution(queue1, queue2));
    }

    public static int solution(int[] queue1, int[] queue2) {
        int answer = 0;

        long sum1 = Arrays.stream(queue1).sum();
        long sum2 = Arrays.stream(queue2).sum();
        long totalSum = sum1 + sum2;

        // 두 큐의 합이 홀수인 경우 -1 반환
        if (totalSum % 2 != 0) {
            return -1;
        }

        // 목표 합계는 두 큐의 합을 2로 나눈 값
        long target = totalSum / 2;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for(int i = 0; i < queue1.length; i++) {
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }


        while (sum1 != target && answer < (queue1.length + queue2.length) * 2) {
            if (sum1 > target) {
                int num = q1.poll();
                sum1 -= num;
                sum2 += num;
                q2.add(num);
            } else {
                int num = q2.poll();
                sum2 -= num;
                sum1 += num;
                q1.add(num);
            }
            answer++;
        }

        if(sum1 != target) {
            answer = -1;
        }

        return answer;
    }
}
