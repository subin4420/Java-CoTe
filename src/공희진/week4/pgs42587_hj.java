package algorithm;

import java.util.Collections;
import java.util.PriorityQueue;

public class pgs42587_hj {
    public static void main(String[] args) {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;

        System.out.println(solution(priorities, location));
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;
        //내림차순
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        // 우선순위 배열 -> 큐에 넣기
        for(int i = 0; i< priorities.length; i++) {
            queue.offer(priorities[i]);
        }

        // 큐가 비어있지 않을 때까지 반복
        while (!queue.isEmpty()) {
            // 우선순위 배열을 돌면서 현재 작업의 위치 찾기
            for (int i = 0; i < priorities.length; i++) {
                if (queue.peek() == priorities[i]) {
                    // 현재 작업의 우선순위가 가장 높은 경우
                    queue.poll(); // 우선순위 배열에서 제거
                    answer++;

                    // 현재 작업이 location과 같은 경우
                    if (location == i) {
                        return answer;
                    }
                }
            }
        }

        return answer;
    }
}

