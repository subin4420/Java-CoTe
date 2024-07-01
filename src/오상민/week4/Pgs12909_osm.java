import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = false;
        Stack<Character> stack = new Stack();
        if (s.charAt(0) == ')' || s.charAt(s.length() - 1) == '(') {
            answer = false;
        } else {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == ')') {
                    if (!stack.empty()) {
                        stack.pop();
                    }
                } else {
                    stack.push(c);
                }
            }
            if (stack.empty()) {
                answer = true;
            }
        }
        return answer;
    }
}