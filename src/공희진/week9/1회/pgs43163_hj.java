package algorithm.graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class 단어변환 {
    public static int nowMin;
    public static boolean[] visited;

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(Solution(begin, target, words));
    }

    public static int Solution(String begin, String target, String[] words) {
        boolean check = false;
        for(String x: words) {
            if (x.equals(target)) check = true;
        }
        if (!check) return 0;

        nowMin = 10000;
        visited = new boolean[words.length];

        dfs(words, target, begin, 0);

        return nowMin;
    }

    public static void dfs(String[] words, String target, String now, int cnt) {
        if (target.equals(now)) {
            nowMin = Math.min(nowMin, cnt);
            return;
        }
        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && isChangeable(now, words[i])) {
                visited[i] = true;
                dfs(words, target, words[i], cnt + 1);
                visited[i] = false;
            }
        }
    }

    public static boolean isChangeable(String origin, String target) {
        int tmp = 0;
        for (int i = 0; i < origin.length(); i++) {
            if (origin.charAt(i) == target.charAt(i)) {
                tmp++;
            }
        }
        return origin.length() -1 == tmp ? true : false;
    }
}
