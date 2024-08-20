package ct_0819;
import java.util.*;

public class pgs_42627_sb {

    class Solution {
        public int solution(int[][] jobs) {
            // 1. 작업을 도착 시간 기준으로 오름차순 정렬
            Arrays.sort(jobs, (j1, j2) -> j1[0] - j2[0]);

            // 2. 소요 시간이 짧은 작업을 먼저 처리하기 위해 우선순위 큐를 사용
            PriorityQueue<int[]> pq = new PriorityQueue<>((j1, j2) -> j1[1] - j2[1]);
            int currentTime = 0; // 현재 시각
            int totalResponseTime = 0; // 총 응답 시간
            int jobIndex = 0; // 작업 배열의 현재 인덱스
            int completedJobs = 0; // 완료된 작업 수

            // 3. 모든 작업이 완료될 때까지 반복
            while (completedJobs < jobs.length) {
                // 현재 시각까지 도착한 모든 작업을 큐에 추가
                while (jobIndex < jobs.length && jobs[jobIndex][0] <= currentTime) {
                    pq.add(jobs[jobIndex]);
                    jobIndex++;
                }

                // 4. 우선순위 큐에서 소요 시간이 가장 짧은 작업을 꺼내 처리
                if (!pq.isEmpty()) {
                    int[] job = pq.poll();
                    currentTime += job[1];
                    totalResponseTime += currentTime - job[0];
                    completedJobs++;
                } else {
                    // 5. 큐가 비어있다면, 다음 작업의 도착 시간으로 현재 시간을 이동
                    currentTime = jobs[jobIndex][0];
                }
            }

            // 6. 평균 응답 시간 계산
            return totalResponseTime / jobs.length;
        }
    }

}
