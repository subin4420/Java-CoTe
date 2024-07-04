package cote_0701;
import java.util.*;
//롤케이크 자르기
public class psg132265_sb {
    class Solution {
        public int solution(int[] topping) {
            int answer = 0;
            HashSet<Integer> hs = new HashSet<>();
            int[] left = new int[topping.length];
            int[] right = new int[topping.length];
            for (int i = 0; i < left.length; i++) {
                hs.add(topping[i]);
                left[i] = hs.size();
            }
            hs.clear();
            for (int i = right.length-1; i >= 0; i--) {
                hs.add(topping[i]);
                right[i] = hs.size();
            }
            for (int i = 0; i < left.length-1; i++) {
                if(left[i] == right[i+1]) {answer++;}
            }
            return answer;
        }
    }
}
