package cote_0701;
import java.util.*;
import java.util.stream.Collectors;
//두 큐 합 같게 만들기
public class pgs118667_sb {
    class Solution {
        public long sum(Queue<Long> q){
            return q.stream()
                    .mapToLong(Long::longValue)
                    .sum();
        }
        public int solution(int[] queue1, int[] queue2) {
            int answer = 0;
            long sum = 0;
            for (int k : queue1) {
                sum += k;
            }
            for (int j : queue2) {
                sum += j;
            }
            long goal = sum/2;
            Queue<Long> lq1 = Arrays.stream(queue1)
                    .mapToLong(i->(long)i)
                    .boxed()
                    .collect(Collectors.toCollection(LinkedList::new));
            Queue<Long> lq2 = Arrays.stream(queue2)
                    .mapToLong(i->(long)i)
                    .boxed()
                    .collect(Collectors.toCollection(LinkedList::new));

            long sum1 = sum(lq1);
            while(true){
                if(lq1.isEmpty() || lq2.isEmpty()){
                    answer=-1;
                    break;
                }
                if(answer>queue1.length*3){answer=-1;break;}
                if(sum1>goal){
                    long lq1poll = lq1.poll();
                    sum1 -= lq1poll;
                    lq2.add(lq1poll);
                    answer++;
                }
                else if(sum1<goal){
                    long lq2poll = lq2.poll();
                    sum1 += lq2poll;
                    lq1.add(lq2poll);
                    answer++;
                }
                else{
                    break;
                }
            }



            return answer;
        }
    }
}

