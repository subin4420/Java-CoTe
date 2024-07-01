import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();

        int idx = 0;
        
        while(idx < progresses.length) {
            if(progresses[idx] < 100) {
                for(int i = idx; i < progresses.length; i++) {
                    progresses[i] += speeds[i];
                }
            } else {
                int cnt = 0;
                while (idx < progresses.length && progresses[idx] >= 100) {
                    idx++;
                    cnt++;
                }
                list.add(cnt);
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}