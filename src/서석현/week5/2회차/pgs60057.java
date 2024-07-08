//문자열 압축
package Programmers;

public class pgs60057 {
    static class Solution {
        public int solution(String s) {
            // 문자열의 초기 길이를 정답으로 설정
            int answer = s.length();

            // 1부터 문자열 길이의 절반까지 단위를 증가시키며 문자열을 압축
            for (int i = 1; i <= s.length() / 2; i++) {
                StringBuilder result = new StringBuilder();
                String base = s.substring(0, i); // 현재 기준이 되는 문자열 단위
                int count = 1; // 반복되는 문자열의 개수를 셀 변수

                // 단위 간격으로 문자열을 탐색
                for (int j = i; j <= s.length(); j += i) {
                    int endIdx = Math.min(j + i, s.length()); // 끝 인덱스를 문자열 길이를 넘지 않도록 설정
                    String compare = s.substring(j, endIdx); // 비교할 다음 문자열 단위

                    if (base.equals(compare)) {
                        // 현재 기준 문자열과 다음 문자열 단위가 같으면 카운트 증가
                        count++;
                    } else {
                        // 현재 기준 문자열과 다음 문자열 단위가 다르면 결과 문자열에 추가
                        if (count >= 2) {   //카운트가 1이면 그냥 추가
                            result.append(count); // 반복된 횟수를 추가
                        }
                        result.append(base); // 현재 기준 문자열 추가
                        base = compare; // 기준 문자열을 다음 문자열 단위로 변경
                        count = 1; // 카운트 초기화
                    }
                }

                // 마지막 남은 기준 문자열 추가
                if (count >= 2) {
                    result.append(count);
                }
                result.append(base);

                // 압축된 문자열의 길이와 현재 최소 길이 비교 후 갱신
                answer = Math.min(answer, result.length());
            }

            // 최소 길이 반환
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "aabbaccc";
        System.out.println(solution.solution(s));
    }
}
