import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        for (String p : completion) {
            map.put(p, map.getOrDefault(p, 0) - 1);
        }

        // for문으로도 풀 수 있다.
        for (Map.Entry<String, Integer> next : map.entrySet()) {
            if (next.getValue() != 0) {
                answer = next.getKey();
                break;
            }
        }

//        Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();
//
//        while (iter.hasNext()) {
//            Map.Entry<String, Integer> next = iter.next();
//            if (next.getValue() == 1) {
//                answer = next.getKey();
//                break;
//            }
//        }


        return answer;
    }
}
