//더 맵게
package Programmers;

import java.util.PriorityQueue;

public class pgs42626 {
    static class Solution {
        public int solution(int[] scoville, int K) {
            PriorityQueue<Integer> heap = new PriorityQueue<>();    // 최소값 구할 때 사용
            int cnt = 0;

            for(int sc : scoville){
                heap.add(sc);
            }

            while (heap.peek() < K){
                if(heap.size() == 1) {
                    return -1;
                }
                heap.add(heap.poll() + (heap.poll() * 2));  // 가장 작은 두 개의 수를 꺼내서 계산
                cnt++;
            }


            return cnt;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] sc = new int[]{1,2,3,9,10,12};
        int k = 7;
        System.out.println(solution.solution(sc, k));
    }
}
