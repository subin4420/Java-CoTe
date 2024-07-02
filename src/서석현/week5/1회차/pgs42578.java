//의상
package Programmers;

import java.util.HashMap;

public class pgs42578 {
    static class Solution {
        public int solution(String[][] clothes) {
            HashMap<String, Integer> hm = new HashMap<>();
            int answer = 1;
            for(String[] n : clothes) {
                hm.put(n[1], hm.getOrDefault(n[1], 0)+1);
            }

            for(int cnt : hm.values()) {
                answer *= (cnt + 1);
            }


            return (answer-1);  //아무것도 입지 않은 경우를 제외 해야 하기 때문에 -1
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[][] clothes = {
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}
        };
        System.out.println(solution.solution(clothes));
    }
}
