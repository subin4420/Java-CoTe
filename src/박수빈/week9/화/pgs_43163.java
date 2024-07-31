package ct_0730;
import java.util.*;

//단어 변환
//bfs
//가능한 모든 걸 예약에 넣어둔다.
//넣었다면 visited 반영한다.
//하나씩 뽑아서 다시 예약에 넣는다.
//뽑아서 해야할 것을 한다.(여기서는 해당 단어가 목표한 것과 같은가를 본다)
//이후 예약을 해야한다. 여기서는 예약할 때 조건이 존재한다.
//뽑았던 단어와 한 글자 차이어여 한다는 점이다.(별도 메서드로)
//뽑을 큐가 비었다면 끝난 것
public class pgs_43163 {
    public class Solution {
        public int solution(String begin, String target, String[] words) {
            Queue<WordState> queue = new ArrayDeque<>(); // BFS를 위한 큐 생성
            boolean[] visited = new boolean[words.length]; // 각 단어의 방문 여부를 체크하는 배열

            // 시작 단어를 큐에 추가, 변환 횟수는 0부터 시작
            queue.add(new WordState(0, begin));

            // BFS 탐색을 통해 정답을 구함
            while (!queue.isEmpty()) {
                WordState cur = queue.remove(); // 큐에서 현재 상태를 가져옴
                // 현재 단어가 목표 단어와 같으면 변환 횟수를 반환
                if (cur.word.equals(target)) return cur.cnt;

                // 주어진 단어 리스트를 순회하며 다음 변환 단어를 찾음
                for (int i = 0; i < words.length; i++) {
                    // 아직 방문하지 않았고, 한 글자 차이인 단어를 찾음
                    if (!visited[i] && getDiffCount(cur.word, words[i]) == 1){
                        visited[i] = true; // 해당 단어를 방문으로 표시
                        queue.add(new WordState(cur.cnt + 1, words[i])); // 변환 횟수를 증가시키고 큐에 추가
                    }
                }
            }

            // 목표 단어에 도달할 수 없으면 0을 반환
            return 0;
        }

        // 두 단어의 다른 글자 수를 계산하는 메소드
        int getDiffCount(String word, String target) {
            int diffCount = 0;
            // 두 단어의 각 글자를 비교하여 다른 글자의 수를 셈
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) != target.charAt(i)) diffCount++;
            }

            // 다른 글자의 수를 반환
            return diffCount;
        }

        // BFS 상태를 나타내는 클래스
        class WordState {
            int cnt; // 변환 횟수
            String word; // 현재 단어

            WordState(int cnt, String word) {
                this.cnt = cnt;
                this.word = word;
            }
        }
    }

}
