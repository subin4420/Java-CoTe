//두 큐 합 같게 만들기
package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class pgs118667 {
    static class Solution {
        public int solution(int[] queue1, int[] queue2) {
//            Queue<Integer> q1 = new LinkedList<>();
//            Queue<Integer> q2 = new LinkedList<>();
//
//            long sum1 = 0;
//            long sum2 = 0;
//            long sum_result;
//            int cnt = 0;
//
//            for(int i : queue1){
//                q1.add(i);
//                sum1 += i;
//            }
//
//            for(int i : queue2){
//                q2.add(i);
//                sum2 += i;
//            }
//
//
//            sum_result = (sum1 + sum2) / 2;
//
//            while (true) {
//                if(sum1 == sum_result){
//                    break;
//                }
//
//                if(sum1 < sum2){
//                    q1.add(q2.poll());
//                    sum2 = sum2 - q2.peek();
//                    cnt++;
//                }
//
//                if(sum1 > sum2) {
//                    q2.add(q1.poll());
//                    sum1 = sum1 - q1.peek();
//                    cnt++;
//                }
//            }
//
//            return cnt;

            int cnt = 0;

            long sum_total=0;   //두큐의합
            long sum1=0;    //1번큐의합
            Queue<Integer> q1 = new LinkedList<Integer>();
            Queue<Integer> q2 = new LinkedList<Integer>();
            for(int i=0; i<queue1.length; i++) {
                sum_total += queue1[i]+queue2[i];
                sum1 += queue1[i];
                q1.add(queue1[i]);
                q2.add(queue2[i]);
            }
            if(sum_total%2!=0) return -1;   // 두 큐의 합이 홀수면 같게 만들 수 없음

            long target = sum_total/2;


            while(true) {   // 두 큐의 합을 같게 만드는 과정
                if(cnt>(queue1.length+queue2.length)*2) return -1;
                if(sum1==target) break;
                else if(sum1>target) {
                    sum1-=q1.peek();
                    q2.add(q1.poll());
                }else {
                    sum1 += q2.peek();
                    q1.add(q2.poll());
                }
                cnt++;
            }

            return cnt;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] q1 = new int[]{1,2,1,2};
        int[] q2 = new int[]{1,10,1,2};

        System.out.println(solution.solution(q1, q2));
    }
}
