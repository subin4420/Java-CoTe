package algorithm;

import java.util.Arrays;

public class psg138985_hj {
    public static void main(String[] args) {
        int[] sequence = {1, 2, 3, 4, 5};
        int k = 7;
        System.out.println(solution(sequence, k));
    }

    public static int[] solution(int[] sequence, int k){
        int[] answer = {-1, -1};
        int sum = 0;
        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;

        while(end < sequence.length) {
            sum += sequence[end];

            while (sum >= k && start <= end) {
                // 현재 누적합이 k와 같은 경우
                if(sum == k) {
                    // 현재 포인터 간 길이가 이전 포인터 간 길이보다 작은 경우
                    if(end - start + 1  < min) {
                        min = end - start + 1;
                        answer[0] = start;
                        answer[1] = end;
                    }
                }
                //start 포인터 이동
                sum -= sequence[start];
                start++;
            }
            end++;
        }

        return answer;
    }
}
