package ct_0801;
import java.util.*;
//호텔 대실
public class pgs155651_sb {

    class Solution {
        public int solution(String[][] book_time) {
            int[][] times = new int[book_time.length][2];

            // 예약 시간을 분으로 변환
            for (int i = 0; i < book_time.length; i++) {
                String[] start = book_time[i][0].split(":");
                String[] end = book_time[i][1].split(":");
                //시작시간을 분으로 환산 time0
                times[i][0] = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
                //종료시간을 분으로 환산 time1
                times[i][1] = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]) + 10;
            }

            // 시작 시간 기준으로 정렬
            Arrays.sort(times, (a, b) -> Integer.compare(a[0], b[0]));

            // 우선순위 큐를 사용하여 최소 객실 수 계산
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int[] time : times) {
                if (!pq.isEmpty() && pq.peek() <= time[0]) {
                    pq.poll();
                }
                pq.add(time[1]);
            }

            return pq.size();
        }
    }

}
