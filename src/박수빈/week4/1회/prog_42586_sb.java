package Q1;
import java.util.Queue;
import java.util.LinkedList;
import java.util.*;
public class prog_42586 {

    class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            Queue<int[]> q = new LinkedList<>();
            List<Integer> result = new ArrayList<>();
            int cnt = 0;

            for (int i = 0; i < progresses.length; i++) {
                //작업량과 속도를 한 뭉탱이로 관리
                q.add(new int[]{progresses[i], speeds[i]});
            }

            while (!q.isEmpty()) {
                //모든 작업이 100될때까지 계속
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    //1일 모든 작업에 스피드 만큼 더해주고 q맨뒤로 삽입
                    //원래 size만큼 시도 -> 원래 큐에 스피드 더한 값
                    int[] element = q.poll();
                    int newProgress = element[0] + element[1];
                    q.add(new int[]{newProgress, element[1]});
                }

                // 큐의 첫 번째 요소가 100 이상인 경우 제거하고 cnt업
                while (!q.isEmpty() && q.peek()[0] >= 100) {
                    q.poll();
                    cnt++;
                }
                //완료된거있을경우 리스트로추가
                if (cnt > 0) {
                    result.add(cnt);
                    cnt = 0;  // cnt 초기화
                }
            }

            // List를 배열로 변환
            int[] answer = new int[result.size()];
            for (int i = 0; i < result.size(); i++) {
                answer[i] = result.get(i);
            }

            return answer;
        }
    }
}
