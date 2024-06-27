package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class pgs_주식가격 {
    public static int[] Solution(int[] price) {
        int[] answer = new int[price.length];
        Queue<Integer> q = new LinkedList<>();

        //배열의 모든 요소를 큐에 추가
        for(int i : price) {
            q.add(i);
        }

        int index = 0;
        while(!q.isEmpty()) {   //큐가 빌 때까지 반복
            int currentPrice = q.poll();    //큐에서 현재 가격을 꺼낸다

            for(int i = index + 1; i < price.length; i++) {     //현재 가격의 다음 가격부터 비교
                if(currentPrice > price[i]){    //가격이 떨어진 경우, +1 을 증가시키고 반복문을 종료합니다.
                    answer[index]++;
                    break;
                }
                if(currentPrice <= price[i]) {  //가격이 떨어지지 않은 경우, +1 값을 증가시킵니다.
                    answer[index]++;
                }
            }
            index++;
        }
        return answer;
    }
}
