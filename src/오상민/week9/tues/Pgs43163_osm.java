/**
 * 단어 변환
 */

import java.util.*;

class Solution {
    Queue<Pair> que;
    boolean[] visited;

    class Pair {
        String word;
        int index;
        int count;

        public Pair(String word, int index, int count) {
            this.word = word;
            this.index = index;
            this.count = count;
        }
    }

    boolean isTrue(String before, String after) {
        int count = 0;
        for (int i = 0; i < before.length(); i++) {
            if (before.charAt(i) != (after.charAt(i))) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    }

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        que = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            if (isTrue(begin, words[i])) {
                que.add(new Pair(words[i], i, 1));
            }
        }
        while (!que.isEmpty()) {
            Pair pair = que.remove();
            visited[pair.index] = true;
            if (pair.word.equals(target)) {
                return pair.count;
            }
            for (int i = 0; i < words.length; i++) {
                if (i != pair.index && isTrue(pair.word, words[i])) {
                    if (!visited[i]) {
                        que.add(new Pair(words[i], i, pair.count + 1));
                    }
                }
            }
        }
        return 0;
    }
}