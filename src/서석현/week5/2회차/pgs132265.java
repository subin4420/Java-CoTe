//롤케이크 자르기
package Programmers;

import java.util.HashMap;
import java.util.Map;

public class pgs132265 {
    static class Solution {
        public int solution(int[] topping) {
            int count = 0;

            Map<Integer, Integer> m1 = new HashMap<>();
            Map<Integer, Integer> m2 = new HashMap<>();

            for (int top : topping) {
                m1.put(top, m1.getOrDefault(top, 0) + 1);
            }

            // 토핑을 하나씩 이동하면서 두 맵의 서로 다른 키의 개수를 비교
            for (int top : topping) {
                // map2에 추가
                m2.put(top, m2.getOrDefault(top, 0) + 1);

                // map1에서 제거
                if (m1.get(top) == 1) {
                    m1.remove(top);
                } else {
                    m1.put(top, m1.get(top) - 1);
                }

                if (m1.size() == m2.size()) {
                    count++;
                }
            }

            return count;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] top = new int[]{1, 2, 1, 3, 1, 4, 1, 2};
        System.out.println(solution.solution(top));
    }
}
