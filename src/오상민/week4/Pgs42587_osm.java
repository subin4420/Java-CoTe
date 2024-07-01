import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : priorities) {
            que.add(num);
        }
        while (!que.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == que.peek()) {
                    que.poll();
                    answer++;
                    if (i == location)
                        return answer;
                }
            }
        }
        return answer;
    }
}