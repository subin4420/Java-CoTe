package Programmers;

import java.util.Arrays;

public class pgs_기능개발 {
    class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            int[] dayOfend = new int[100];  // 각 날짜별로 완료된 작업의 수를 저장할 배열
            int day = -1; // 현재 날짜를 추적하는 변수

            // 각 작업의 완료 날짜를 계산하여 dayOfend 배열에 저장
            for (int i = 0; i < progresses.length; i++) {
                // 작업이 100% 완료될 때까지의 날짜를 증가시킴
                while (progresses[i] + (day * speeds[i]) < 100) {
                    day++;
                }
                // 해당 날짜에 완료된 작업 수를 증가시킴
                dayOfend[day]++;
            }

            // dayOfend 배열에서 0이 아닌 값을 필터링하여 최종 결과 배열 생성
            return Arrays.stream(dayOfend).filter(i -> i != 0).toArray();
        }
    }
}
