package ct_0730;
import java.util.*;
//네트워크
public class pgs_43162 {
    class Solution {
        public int solution(int n, int[][] computers) {
            int answer = 0;
            boolean[] visited = new boolean[n];
            // for(boolean a : visited){
            //     a = false;
            // }
            for(int i=0;i<n;i++){
                if(!visited[i]){
                    dfs(i,n, computers, visited);
                    answer++;
                }
            }
            return answer;
        }

        public void dfs(int curr,int n, int[][] computers, boolean[] visited){
            visited[curr] = true;

            for(int i=0;i<n;i++){
                if(!visited[i] && computers[curr][i] == 1)
                {
                    dfs(i,n,computers,visited);
                }
            }

        }

    }
}
