import java.util.*;

/**
 * 롤케이크 자르기
 */
class Solution {
    public int solution(int[] topping) {
        HashSet<Integer> set1 = new HashSet<>();
        HashMap<Integer, Integer> set2 = new HashMap<>();
        int answer = 0;

        set1.add(topping[0]);
        for (int i = 1; i < topping.length; i++) {
            if (set2.containsKey(topping[i])) {
                set2.replace(topping[i], set2.get(topping[i]) + 1);
            } else {
                set2.put(topping[i], 1);
            }
        }
        if (set1.size() == set2.size()) {
            answer++;
        }

        for (int i = 1; i < topping.length - 1; i++) {
            set1.add(topping[i]);
            if (set2.get(topping[i]) == 1) {
                set2.remove(topping[i]);
            } else {
                set2.replace(topping[i], set2.get(topping[i]) - 1);
            }

            if (set1.size() == set2.size()) {
                answer++;
            }
        }
        return answer;
    }
}