package Programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class pgs138982 {
    static class Solution {
        public String solution(String[] participant, String[] completion) {

            //HashMap 풀이
            HashMap<String, Integer> hm = new HashMap<>();

            // 참가자 배열에서 각 이름의 빈도를 카운트     *이름을 key값, 빈도를 value
            for(String p : participant) {
                hm.put(p, hm.getOrDefault(p, 0)+1);
            }

            // 완주한 선수 배열에서 각 이름의 빈도를 감소
            for(String c : completion) {
                hm.put(c, hm.get(c) - 1);
            }

            // 빈도가 0이 아닌 참가자를 찾기
            for(String a : hm.keySet()) {
                if(hm.get(a) != 0) {
                    return a;
                }
            }
            return "";

            //Arrays 풀이
//            Arrays.sort(participant);
//            Arrays.sort(completion);
//
//            for(int i = 0; i < completion.length; i++) {
//                if(!participant[i].equals(completion[i])) {
//                    return participant[i];
//                }
//            }
//
//            return participant[participant.length - 1];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] participant = new String[]{"a", "b", "a", "d", "h"};
        String[] completion = new String[]{"b", "d" , "a",};

        System.out.println(solution.solution(participant, completion));
    }
}
