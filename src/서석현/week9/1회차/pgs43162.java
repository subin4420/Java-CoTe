//네트워크
package Programmers;

public class pgs43162 {
    static class Solution {
        public int solution(int n, int[][] computers) {
            int count = 0;
            boolean[] visited = new boolean[n];

            for(int i = 0; i < n; i++){
                if(visited[i]) {
                    continue;
                }
                dfs(n, computers, visited, i);
                count++;
            }

            return count;
        }

        void dfs(int n, int[][] computers, boolean[] visited, int cur){
            visited[cur] = true;

            for(int i = 0; i < n; i++){
                if(!visited[i] && computers[cur][i] == 1) {
                    dfs(n, computers, visited, i);
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 3;
        int[][] computers = new int[][]{{1,1,0}, {1,1,0}, {0,0,1}};
        System.out.println(solution.solution(n,computers));
    }
}
