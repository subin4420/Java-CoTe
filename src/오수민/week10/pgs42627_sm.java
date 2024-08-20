import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;

        //작업이 요청되는 시점이 빠른 순서로 정렬
        //[0][0] - [1][0]
        Arrays.sort(jobs, (j1,j2)->j1[0]-j2[0]);

        //적은 소요시간 순으로 큐에 담을 거임
        Queue<int[]> pq = new PriorityQueue<>((j1,j2)->j1[1]-j2[1]);
        int curTime = 0; //현재 시간
        int completedJobs = 0; //완수한 작업
        int totalRespTime = 0; //총 응답 시간
        int jobIdx = 0;

        //현재 처리 가능한 것 들 중 작업 시간 가장 적은 것 부터
        while(completedJobs < jobs.length){ //모든 잡을 완수하면 끝
            //현재 시간에 처리할 수 있는 작업들을 우선순위 큐에 추가
            while(jobIdx<jobs.length && jobs[jobIdx][0] <= curTime){
                pq.add(jobs[jobIdx++]);
            }
            //우선순위 큐를 이용해서 소요시간 가장 적은 작업 선택
            //작업의 요청부터 종료까지 걸린시간을 더해줌
            //현재 시간을 업데이트
            if(!pq.isEmpty()){
                int[] job = pq.remove();
                curTime+=job[1];
                totalRespTime += curTime - job[0]; //현재 시간이 9, 작업 시작시간이 1 -> 8 기다림
                completedJobs++;
            }else{
                //현재 시간 업데이트
                curTime = jobs[jobIdx][0];
            }

        }

        //총 대기시간 평균 계산해서 반환
        return totalRespTime/jobs.length;
    }
}