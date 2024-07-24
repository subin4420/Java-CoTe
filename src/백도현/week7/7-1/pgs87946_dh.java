import java.util.*;
class Solution {
    static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        int answer = 0;
        List<List<int[]>> list = new ArrayList<>();
        visited = new boolean[dungeons.length];
        
        dfs(dungeons, new ArrayList<>(), list);
        
        
        for (List<int[]> x: list) {
            int tmp = k;
            int cnt = 0;
            for (int[] arr: x) {
                if (arr[0] > tmp) {
                    break;
                }
                tmp -= arr[1];
                cnt++;
            }
            answer = Math.max(cnt, answer);
        }
        
        return answer;
    }
    
}