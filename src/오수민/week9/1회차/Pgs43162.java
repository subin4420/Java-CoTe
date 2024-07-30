package algo4.네트워크;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pgs43162 {
    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static Map<Integer, Boolean> visited = new HashMap<>();

    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];

        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i,n,computers,visited);
                answer++;
            }
        }
        return answer;
    }

    void dfs(int cur, int n, int[][] computers, boolean[] visited) {
        visited[cur] = true;

        for (int i = 0; i < n; i++) {
            if(computers[cur][i] == 1) {
                if(!visited[i])
                    dfs(i, n, computers, visited);
            }
        }

    }

}

