// 프로그래머스 알고리즘 고득점kit/힙/더 맵게
import java.util.*;

public class pgs42626_bgm {
    class Solution {
        public int solution(int[] scoville, int K) {
            int answer = 0;
            PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
            for (int i = 0; i < scoville.length; i++) {
                queue.add(scoville[i]);
            }

            while(queue.peek() < K) {
                Integer a = queue.poll();
                Integer b = queue.poll();

                Integer mix = a + (b * 2);
                queue.offer(mix);
                answer++;
            }
            return answer;
        }
    }
}
