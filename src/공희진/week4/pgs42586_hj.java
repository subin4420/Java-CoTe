package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class pgs42586_hj {
    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        System.out.println(Arrays.toString(solution(progresses, speeds)));
    }

    public static int[] solution(int[] progresses, int[] speeds){
        ArrayList<Integer> answer = new ArrayList<Integer>(); //배포되는 기능 수
        Queue<Integer> q = new LinkedList<>(); //배포까지 걸리는 기간

        int day = 0; // 배포까지 걸리는 기간
        for(int i = 0; i < progresses.length; i++) {
            while(progresses[i] + (speeds[i] * day) < 100) {
                day++; //100이상 될때까지 걸리는 기간
            }
            q.offer(day); //[5,10,10,10,20,20]
        }

        while (!q.isEmpty()) {
            int currentDay = q.poll(); // 초기 비교 대상 값 -> 5
            int cnt = 1; // 배포되는 기능 수
            while (!q.isEmpty() && currentDay >= q.peek()) { // 현재 배포 날이 다음 배포 날보다 크거나 같을 때
                cnt++;
                q.poll();
            }
            answer.add(cnt); // 배포되는 기능 수 추가
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
