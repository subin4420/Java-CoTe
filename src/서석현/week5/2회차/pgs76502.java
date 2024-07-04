//괄호 회전하기
package Programmers;

import java.util.Stack;

public class pgs76502 {
    static class Solution {
        public int solution(String s) {
            int cnt = 0;

            for (int i = 0; i < s.length(); i++) {
                Stack<Character> stack = new Stack<>();

                String str = s.substring(i) + s.substring(0, i);    //문자열 회전

                //열린 괄호는 스택에 추가하고 닫힌 괄호가 나오면 스택의 최상단이 대응되는 여는 괄호인지 확인 후 제거
                //스택이 비어있으면 카운트 아니면 노카운트
                for (int j = 0; j < str.length(); j++) {
                    char c = str.charAt(j);
                    if (stack.isEmpty()) {
                        stack.push(c);
                    } else if (c == ')' && stack.peek() == '(') {
                        stack.pop();
                    } else if (c == '}' && stack.peek() == '{') {
                        stack.pop();
                    } else if (c == ']' && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                }
                if (stack.isEmpty()) {
                    cnt++;
                }
            }

            return cnt;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("[](){}"));
    }
}
