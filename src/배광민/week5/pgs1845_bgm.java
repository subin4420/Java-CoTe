//프로그래머스 알고리즘 고득점 kit/해시/폰켓몬
import java.util.*;

public class pgs1845_bgm {
    public class Solution {
        public int solution(int[] nums) {
            int answer = 0;
            int max = nums.length / 2;

            HashSet<Integer> hs = new HashSet<>();

            for (int i : nums) {
                hs.add(i);
            }

            if (hs.size() > max) {
                answer = max;
            } else {
                answer = hs.size();
            }

            return answer;
        }
    }
}
