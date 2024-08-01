package algorithm.week9;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 호텔대실 {
    public int solution(String[][] book_time) {
        //대실 시작 시간 기준 오름차순 정렬
        Arrays.sort(book_time,(o1, o2)-> {
            int time1 = Integer.parseInt(o1[0].split(":")[0]) * 60 + Integer.parseInt(o1[0].split(":")[1]);
            int time2 = Integer.parseInt(o2[0].split(":")[0]) * 60 + Integer.parseInt(o2[0].split(":")[1]);
            return time1-time2;
        });

        int room =1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 대실 종료 시간 기준 오름차순 정렬
        for(int i=0; i<book_time.length; i++){
            int start = Integer.parseInt(book_time[i][0].split(":")[0]) * 60 + Integer.parseInt(book_time[i][0].split(":")[1]);
            int fin = Integer.parseInt(book_time[i][1].split(":")[0]) * 60 + Integer.parseInt(book_time[i][1].split(":")[1]);

            if(pq.isEmpty()) {
                pq.add(fin);
            }
            else{
                //가장 빨리 비는 방의 종료시간 + 10 > 현재 예약 시작 시간
                if(pq.peek()+10 > start) {
                    room++;
                }
                else { // 기존 방 체크아웃 한 후 바로 사용할 수 있는 상태
                    pq.poll();
                }

                pq.add(fin);
            }
        }
        return room;
    }
}

