import java.util.*;

public class pgs42627_bgm {
    class Solution {
        public int solution(int[][] jobs) {
            Arrays.sort(jobs, (j1, j2) -> j1[0] - j2[0]);

            Queue<int[]> pq = new PriorityQueue<>((j1, j2) -> j1[1] - j2[1]);
            int currentTime = 0;
            int completedJobs = 0;
            int totalResponseTime = 0;
            int jobIndex = 0;

            while (completedJobs < jobs.length) {
                while (jobIndex < jobs.length && jobs[jobIndex][0] <= currentTime) {
                    pq.add(jobs[jobIndex]);
                    jobIndex++;
                }

                if (!pq.isEmpty()) {
                    int[] job = pq.remove();
                    currentTime += job[1];
                    totalResponseTime += currentTime - job[0];
                    completedJobs++;
                } else {
                    currentTime = jobs[jobIndex][0];
                }
            }
            return totalResponseTime / jobs.length;
        }
    }
}
