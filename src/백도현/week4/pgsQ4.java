import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        answer[1] = Integer.MAX_VALUE;
        int i = 0;
        int j = 1;  
        int sum = sequence[i];
        while (i < j) {
            if (sum == k) {
                if (j -1 - i < answer[1] - answer[0]) {
                    answer[1] = j-1;
                    answer[0] = i;
                }
                sum -= sequence[i++];
            } else if (sum > k) {
                sum -= sequence[i++];
            } else if (j < sequence.length) {
                sum += sequence[j++];
            } else {
                break;
            }
        }
        
        return answer;
    }
}