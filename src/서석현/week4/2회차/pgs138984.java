package Programmers;
import java.util.Arrays;

public class pgs138984 {
    class Solution {
        public int solution(int[] d, int budget) {
            int answer = 0;
            int total = 0;
            Arrays.sort(d);//오름차순 정렬
            for(int i=0;i<d.length; i++){
                if(total+d[i]<=budget) {
                    total += d[i]; //배열의 값을 하나 씩 더한다
                    answer++;
                }
            }
            return answer;
        }
    }
}
