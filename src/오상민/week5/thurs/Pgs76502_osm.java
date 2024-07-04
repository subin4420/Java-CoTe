import java.util.*;

/**
 * 괄호 회전하기
 */
class Solution {
    static boolean isTrue(Queue q) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < q.size(); i++) {
            Character c = (Character) q.poll();
            q.add(c);
            if (stack.empty()) {
                stack.push(c);
            } else if (c == ']' && stack.peek() == '[') {
                stack.pop();
            } else if (c == '}' && stack.peek() == '{') {
                stack.pop();
            } else if (c == ')' && stack.peek() == '(') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        if (stack.empty()) {
            return true;
        } else {
            return false;
        }
    }

    public int solution(String s) {
        Queue<Character> q = new LinkedList<>();
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            Character j = s.charAt(i);
            q.add(j);
        }

        for (int i = 0; i < s.length(); i++) {
            if (isTrue(q)) {
                answer++;
            }
            Character b = q.poll();
            q.add(b);
        }
        return answer;
    }
}