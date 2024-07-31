//단어 변환
package Programmers;

import java.util.ArrayDeque;
import java.util.Queue;

public class pgs43163 {
    static class Solution {
        public int solution(String begin, String target, String[] words) {
            Queue<WordState> q = new ArrayDeque<>();
            boolean[] visited = new boolean[words.length];

            q.offer(new WordState(begin, 0));

            while (!q.isEmpty()){
                //방문
                WordState cur = q.poll();

                //방문한 곳이 내가 찾던 target이라면 return cnt
                if (cur.word.equals(target)) {
                    return cur.cnt;
                }

                //nextvertex 예약
                for(int i = 0; i < words.length; i++){
                    if (getDiffCount(cur.word, words[i]) == 1){
                        if(!visited[i]){
                            q.offer(new WordState(words[i], cur.cnt+1));
                            visited[i] = true;
                        }
                    }
                }
            }
            return 0;
        }

        int getDiffCount(String word, String target) {
            int diffCount = 0;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) != target.charAt(i)) diffCount++;
            }

            return diffCount;
        }

        class WordState {
            String word;
            int cnt;

            WordState(String word, int cnt) {
                this.word = word;
                this.cnt = cnt;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String begin = "hit";
        String target = "cog";
        String[] word = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};

        System.out.println(solution.solution(begin,target,word));
    }
}
