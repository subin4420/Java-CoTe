package cote_0701;
import java.util.*;

public class pgs60057_sb {
    public class Solution {
        public int solution(String s) {
            int answer = s.length();

            // 1부터 문자열 길이의 절반까지 반복
            for (int i = 1; i <= s.length() / 2; i++) {
                StringBuilder compressed = new StringBuilder();
                String prev = s.substring(0, i);
                int count = 1;

                // i 단위로 문자열을 잘라 비교
                for (int j = i; j <= s.length(); j += i) {
                    String sub;
                    if (j + i <= s.length()) {
                        sub = s.substring(j, j + i);
                    } else {
                        sub = s.substring(j);
                    }

                    if (prev.equals(sub)) {
                        count++;
                    } else {
                        if (count > 1) {
                            compressed.append(count).append(prev);
                        } else {
                            compressed.append(prev);
                        }
                        prev = sub;
                        count = 1;
                    }

                }

                // 남아있는 문자열 처리
                if (count > 1) {
                    compressed.append(count).append(prev);
                } else {
                    compressed.append(prev);
                }

                // 압축된 문자열의 길이 갱신
                answer = Math.min(answer, compressed.length());
            }

            return answer;
        }
    }
}
