import java.util.*;

/**
 * 두 큐 합 같게 만들기
 */
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Long> q1 = new LinkedList<>();
        Queue<Long> q2 = new LinkedList<>();
        Long q1Sum = Long.valueOf(0);
        Long q2Sum = Long.valueOf(0);
        for (int i = 0; i < queue1.length; i++) {
            q1Sum += Long.valueOf(queue1[i]);
            q2Sum += Long.valueOf(queue2[i]);
            q1.add(Long.valueOf(queue1[i]));
            q2.add(Long.valueOf(queue2[i]));
        }
        while (q1Sum != q2Sum) {
            if (answer > (queue1.length + queue2.length) * 2) {
                answer = -1;
                break;
            }
            if (q1Sum > q2Sum) {
                q1Sum -= q1.peek();
                q2Sum += q1.peek();
                q2.add(q1.poll());
                answer++;
            } else if (q2Sum > q1Sum) {
                q2Sum -= q2.peek();
                q1Sum += q2.peek();
                q1.add(q2.poll());
                answer++;
            } else {
                return answer;
            }
        }
        return answer;
    }
}