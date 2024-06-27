package Q1;
import java.util.*;

public class prog_42583 {
    class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            int answer = 0;
            int bl = bridge_length;
            int timer = 0;
            int on_bridge_weight = 0;
            Queue<int[]> on_bridge = new LinkedList<>();
            int truck_num = truck_weights.length;
            int i = truck_num;
            int n = 0;//남은 차량 인덱스

            while(n<truck_num || !on_bridge.isEmpty()){
                //트럭을 모두 태우고 큐가 비어있지 않을 때까지
                timer++;
                //차량 다리에서 내리기
                if(!on_bridge.isEmpty() && on_bridge.peek()[1]+bl==timer){
                    on_bridge_weight -= on_bridge.poll()[0];
                }
                //차량 다리로 올리기
                if(n<truck_num && truck_weights[n] + on_bridge_weight<=weight){
                    on_bridge.add(new int[]{truck_weights[n],timer});
                    on_bridge_weight+=truck_weights[n];
                    n++;
                }

            }

            return timer;
        }
    }
}
