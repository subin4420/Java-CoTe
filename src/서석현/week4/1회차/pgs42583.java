package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class pgs_다리를지나는트럭 {
    class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            Queue<Integer> queue = new LinkedList<>();
            int sum = 0;
            int time = 0;

            // 각 트럭의 무게를 순회
            for(int i = 0; i < truck_weights.length; i++) {
                int truck = truck_weights[i]; // 현재 트럭의 무게를 가져옴

                while(true) {
                    // 큐에 아무것도 없는 경우 = 어떠한 트럭도 다리 위에 없음
                    if(queue.isEmpty()) {
                        queue.add(truck); // 트럭을 다리에 올림
                        sum += truck; // 다리 위의 총 무게에 추가
                        time++; // 다리에 오를 때만 시간 추가
                        break;
                    } else if(queue.size() == bridge_length) { // 큐에 다리 길이만큼 트럭이 다 찬 경우
                        sum -= queue.poll(); // 가장 오래된 트럭을 다리에서 내림
                    } else { // 다리 길이만큼 큐가 차지 않았음
                        // weight 값을 넘지 않는 선에서 새로운 트럭을 다리에 올려줌
                        if(sum + truck <= weight) {
                            queue.add(truck); // 트럭을 다리에 올림
                            sum += truck; // 다리 위의 총 무게에 추가
                            time++;
                            break;
                        } else {
                            // 넘는다면 0을 넣어 이미 큐에 있는 트럭이 다리를 건너게 만듦
                            queue.add(0);
                            time++;
                        }
                    }
                }
            }

            // 마지막 트럭에서 반복문이 끝나는데, 마지막 역시 다리 길이만큼 지나가야 하기 때문에 + 다리 길이
            return time + bridge_length;
        }
    }
}
