import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum = 0;
        Queue<Integer> que = new LinkedList<Integer>();
        for (int t : truck_weights) {
            while (true) {
                if (que.isEmpty()) {
                    que.add(t);
                    sum += t;
                    answer++;
                    break;
                } else if (que.size() == bridge_length) {
                    sum -= que.poll();
                } else {
                    if (sum + t > weight) {
                        que.offer(0);
                        answer++;
                    } else {
                        que.offer(t);
                        sum += t;
                        answer++;
                        break;
                    }
                }
            }
        }
        return answer + bridge_length;
    }
}