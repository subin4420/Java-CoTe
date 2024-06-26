import java.util.*;

public class pgs42587_bgm {
    int solution(int[] priorities, int location) {
        int answer = 1;

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for(int priority : priorities) {
            queue.add(priority);
        }

        while(!queue.isEmpty()){
            for(int i = 0; i < priorities.length; i++)

                if(queue.peek() == priorities[i]) {
                    if(i == location) return answer;

                    queue.poll();
                    answer++;
                }
        }

        return answer;
    }
}
