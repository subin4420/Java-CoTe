package algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class pgs42583_hj {
    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};
        System.out.println(solution(bridge_length, weight, truck_weights));
    }

    private static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;
        int time = 0;

        for (int i = 0; i < truck_weights.length; i++) {
            int truck = truck_weights[i];

            while (true) {
                if (queue.isEmpty()) {  //큐 비어있는 경우 -> 다리 위에 트럭 없음
                    queue.offer(truck);
                    sum += truck;
                    time++;
                    break;
                } else if (queue.size() == bridge_length) {  //큐 가득찬 경우
                    sum -= queue.poll();
                } else {// 큐 가득차지 않은 경우
                    if (sum + truck > weight) { // 다리 무게 초과할 경우
                        queue.offer(0); // 트럭 대신 0 넣기 --> 트럭이 다리 건널 수 있도록 함
                        time++;
                    } else { // 다리 무게 이하일 경우
                        queue.offer(truck); // 트럭 넣기
                        sum += truck;
                        time++;
                        break;
                    }

                }
            }


        }

        // 마지막 트럭이 다리를 건너는 시간 추가
        return time + bridge_length;
    }
}