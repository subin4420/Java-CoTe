package Stack;

import java.util.*;

public class Prgm42583 {
    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};

//        int bridge_length = 100;
//        int weight = 100;
//        int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};

        Queue<Integer> queue = new LinkedList<>();

        int time = 0;
        int total_w = 0;
        int i=0;
        while(i<truck_weights.length){
            if (queue.size() >= bridge_length) {
                int tmp = queue.poll();
                total_w -= tmp;
            }
            if (total_w + truck_weights[i] <= weight) {
                queue.add(truck_weights[i]);
                total_w += truck_weights[i];
                i++;
                time++;
            } else {
                queue.add(0);
                time++;
            }
        }

        if(queue.size()>0){
            time+=bridge_length;
        }

        System.out.println(time);
    }
}
