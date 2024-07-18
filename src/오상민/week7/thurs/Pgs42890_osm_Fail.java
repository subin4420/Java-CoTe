/**
 * 후보키
 */

import java.util.*;

class Solution {
    HashSet<String> candidate;
    boolean[] visited;
    int[] isDuplicated;
    int colLen;
    int rowLen;
    void backtrack(String current, string[][] relation, int cnt){
        if(candidate.contains(current)){
            isDuplicated[cnt] = 1;
            return;
        } else {
            candidate.add(current);
        }
        if(cnt == colLen -1){
            return;
        }

        for(int i = 0; i< colLen; i++){
            if(!visited[i]) {
                visited[i] = true;
                String newValue = current + relation[i][cnt+1];
                backtrack(newValue, relation, cnt + 1);
                visited[i] = false;
            }
        }
    }
    public int solution(String[][] relation) {
        int answer = 0;

        candidate = new HashSet<>();
        colLen = relation[0].length;
        rowLen = relation.length;
        visited = new boolean[colLen];
        isDuplicated = new int[colLen];

        for(i=0; i<rowLen; i++){
            backtrack(relation[i][0], relation, 0);
        }
        for(int i = 0; i<colLen; i++){
            if (isDuplicated[i] == 0){
                answer ++;
            } else {

            }
        }
        return answer;
    }
}