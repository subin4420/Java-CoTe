package Programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class pgs_프로세스 {
    class Solution {
        public int solution(int[] priorities, int location) {
            int answer = 0;
            // 내림차순으로 정렬되는 우선순위 큐를 생성
            PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
            // 모든 문서의 중요도를 큐에 추가
            for (int i = 0; i < priorities.length; i++) {
                queue.add(priorities[i]);
            }

            // 큐가 비어 있지 않은 동안 반복
            while (!queue.isEmpty()) {
                for (int i = 0; i < priorities.length; i++) {
                    // 큐의 가장 높은 중요도와 현재 문서의 중요도를 비교
                    if (queue.peek() == priorities[i]) {
                        // 요청된 문서의 위치와 현재 문서의 위치가 일치하는지 확인
                        if (i == location) {
                            answer++; // 출력된 문서 수 증가
                            return answer; // 요청된 문서가 몇 번째로 출력되는지 반환
                        } else {
                            queue.poll(); // 문서를 큐에서 제거
                            answer++; // 출력된 문서 수 증가
                        }
                    }
                }
            }

            return answer;
        }
    }
}
