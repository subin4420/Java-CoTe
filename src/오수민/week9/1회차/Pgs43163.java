package algo4.단어변환;

import java.util.ArrayDeque;
import java.util.Queue;

class Pgs43163 {
    public int solution(String begin, String target, String[] words) {
        Queue<WordState> queue = new ArrayDeque<>(); //큐에 저장할 거 클래스로 만들수 있음
        boolean[] visited = new boolean[words.length];

        queue.offer(new WordState(begin,0));

        while (!queue.isEmpty()) {
            // 방문
            WordState curr = queue.poll();

            // 방문한 곳이 내가 찾던 타겟이라면 return cnt
            if(curr.word.equals(target)) {
                return curr.cnt;
            }

            // nextVertex 예약
            // 원래는 nextVertex만 예약하면 됨, but 이 문제는 알 수 없음,
            // 내가 찾아야함
            for(int i = 0; i < words.length; i++) {
                if(!visited[i] && getDiffCnt(curr.word,words[i])==1) {
                    visited[i] = true;
                    queue.offer(new WordState(words[i],curr.cnt + 1));
                }
            }
        }
        return 0;
    }

    // 큐에 저장할 변수를 클래스로 만들어줌
    class WordState{
        String word;
        int cnt; //몇 번 바뀌나
        WordState(String word, int cnt){
            this.word = word;
            this.cnt = cnt;
        }
    }

    // curr.word vs words[i]
    int getDiffCnt(String word, String target){
        int diffCnt = 0;
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) != target.charAt(i)){diffCnt++;}
        }
        return diffCnt;
    }
}