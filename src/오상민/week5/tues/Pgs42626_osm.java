import java.util.*;

/**
 * 더 맵게
 */

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Long> heap = new PriorityQueue<>();
        int answer = 0;
        for (int i = 0; i < scoville.length; i++) {
            heap.add(Long.valueOf(scoville[i]));
        }
        if (heap.size() == 1 && heap.peek() < K) {
            return -1;
        } else {
            while (heap.peek() < K && heap.size() >= 2) {
                heap.add(heap.poll() + heap.poll() * 2);
                answer++;
            }
            if (heap.peek() < K) {
                return -1;
            } else {
                return answer;
            }
        }
    }
}