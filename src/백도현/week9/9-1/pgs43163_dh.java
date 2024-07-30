class Solution {
    int nowMin;
    boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
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
    
    public void dfs(String[] words, String target, String now, int cnt) {
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
    
    public boolean isChangeable(String origin, String target) {
        int tmp = 0;
        for (int i = 0; i < origin.length(); i++) {
            if (origin.charAt(i) == target.charAt(i)) {
                tmp++;
            }
        }
        return origin.length() -1 == tmp ? true : false;
    }
}

import java.util.*;
class Solution {
    
    public int solution(String begin, String target, String[] words) {
        boolean check = false;
        for(String x: words) {
            if (x.equals(target)) check = true;
        }
        if (!check) return 0;
        
        Deque<Node> q = new ArrayDeque<>();
        boolean[] visited = new boolean[words.length];
        
        q.addFirst(new Node(begin, 0));
        while(!q.isEmpty()) {
            Node now = q.pollLast();
            if(now.str.equals(target)) {
                return now.cnt;
            }
            for(int i = 0; i < words.length; i++) {
                if(!visited[i] && isChangeable(words[i], now.str)) {
                    visited[i] = true;
                    q.addFirst(new Node(words[i], now.cnt + 1));
                }
            }
        }
        
        
        return 0;
    }
    
    
    public boolean isChangeable(String origin, String target) {
        int tmp = 0;
        for (int i = 0; i < origin.length(); i++) {
            if (origin.charAt(i) == target.charAt(i)) {
                tmp++;
            }
        }
        return origin.length() -1 == tmp ? true : false;
    }
    
    class Node{
        String str;
        int cnt;
        
        public Node(String str, int cnt) {
            this.str=str;
            this.cnt=cnt;
        }
    }
}