package Q1;
import java.util.*;

public class prog_42587 {
    class Solution {
        public int solution(int[] priorities, int location) {
            int answer = 0;
            Queue<int[]> q = new LinkedList<>();

            for (int i = 0; i < priorities.length; i++) {
                q.add(new int[]{priorities[i], i});
            }

            Arrays.sort(priorities); // 우선순위가 가장 큰 순으로 정렬
            int size = priorities.length - 1; // 가장 큰 우선순위 가르키는 인덱스

            while (!q.isEmpty()) {
                int[] current = q.poll();
                //뽑아 보기

                //뽑은게 가장 높은 우선순위인지확인
                boolean isHiger = false;

                // 현재 요소보다 높은 우선순위가 있는지 확인합니다.
                for (int[] item : q) {
                    if (item[0] > current[0]) {
                        isHiger = true;
                        break;
                    }
                }

                if (isHiger) {
                    q.add(current); // 우선순위 높은게 있으면 다시 추가
                } else {
                    //이게 가장 우선순위 높으면 결과 +1 프로세스가 하나 실행된거니까
                    answer++;
                    if (current[1] == location) {
                        //거기에 제시한 loc과 동일하면
                        return answer; // 리턴
                    }
                }
            }
            return answer;
        }
    }
}
