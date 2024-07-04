import java.util.*;

/**
 * 문자열 압축
 */
class Solution {
    public int solution(String s) {
        int answer = s.length();
        Queue<Character> que = new LinkedList<>();
        String before = "";
        String after = "";
        int count = 1;

        for (int i = 1; i < s.length() / 2 + 2; i++) {
            count = 1;
            for (int p = 0; p < s.length(); p++) {
                que.add(s.charAt(p));
            }
            int attemp = 0;
            if (s.length() % i == 0) {
                attemp = s.length() / i;
            } else {
                attemp = s.length() / i + 1;
            }
            for (int j = 0; j < attemp; j++) {
                String tmp = "";
                for (int t = 0; t < i; t++) {
                    if (que.size() != 0) {
                        tmp += que.poll().toString();
                    }
                }
                if (tmp.equals(before)) {
                    count++;
                } else {
                    if (count != 1) {
                        after += count;
                    }
                    count = 1;
                    after += before;
                    before = tmp;
                }
                if (j == attemp - 1) {
                    if (count != 1) {
                        after += count;
                    }
                    after += before;
                }
            }
            if (answer > after.length()) {
                answer = after.length();
            }
            before = "";
            after = "";
        }
        return answer;
    }
}