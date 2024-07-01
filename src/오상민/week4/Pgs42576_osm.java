import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hash = new HashMap<>();
        for (int i = 0; i < completion.length; i++) {
            if (hash.containsKey(completion[i])) {
                hash.replace(completion[i], hash.get(completion[i]) + 1);
            } else {
                hash.put(completion[i], 0);
            }
        }
        for (int i = 0; i < participant.length; i++) {
            if (!hash.containsKey(participant[i])) {
                answer = participant[i];
            } else {
                if (hash.get(participant[i]) == 0) {
                    hash.remove(participant[i]);
                } else {
                    hash.replace(participant[i], hash.get(participant[i]) - 1);
                }
            }
        }
        return answer;
    }
}