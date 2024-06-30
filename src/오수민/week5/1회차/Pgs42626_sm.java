package week5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Pgs42626_sm {
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        int answer = 0;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int s:scoville){
            minHeap.add(s);
        }
        while(true){
            if(minHeap.peek()>=K){
                break;
            }
            else if(minHeap.size()==1){
                answer = -1;
                break;
            }
            else{
                Integer newS = minHeap.poll() + minHeap.poll()*2;
                minHeap.add(newS);
                answer++;
            }
        }

//        ArrayList<Integer> arr=new ArrayList<>();

//
//        while(true){
//            Collections.sort(arr);
//            if(arr.get(0)>=7) break;
//            else{
//                Integer newS = arr.remove(0) + arr.remove(0)*2;
//                arr.add(newS);
//                answer++;
//            }
//        }

        System.out.println(answer);
    }
}

