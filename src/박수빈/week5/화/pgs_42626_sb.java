package cote_0701;
import java.util.*;
//더 맵게

public class pgs_42626 {
    class Solution {
        public int solution(int[] scoville, int K) {
            int answer = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int a : scoville){
                pq.add(a);
            }
            if(scoville.length == 0){
                return -1;
            }
            while(pq.peek()<K && pq.size() > 1){
                int high = 0;
                int low = 0;
                if(!pq.isEmpty()){
                    low=pq.poll();
                }
                else{
                    return -1;
                }
                if(!pq.isEmpty()){
                    high=pq.poll();
                }
                else{
                    return -1;
                }
                pq.add(low + high*2);
                answer++;
            }

            if(pq.size() ==1 && pq.peek()<K){
                return -1;
            }

            System.out.println(pq);
            return answer;
        }
    }
}
