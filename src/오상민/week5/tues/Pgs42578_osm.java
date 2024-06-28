import java.util.*;

/**
 * 의상
 */

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            if (map.containsKey(clothes[i][1])) {
                map.replace(clothes[i][1], map.get(clothes[i][1]) + 1);
            } else {
                map.put(clothes[i][1], 1);
            }
        }
        if (map.size() != 1) {
            answer = 1;
            for (String i : map.keySet()) {
                answer = answer * (map.get(i) + 1);
            }
            answer--;
        } else {
            for (String i : map.keySet()) {
                answer += map.get(i);
            }
        }
        return answer;
    }
}