package algorithm.week5;
//괄호 회전하기
import java.util.Stack;

public class pgs76502_hj {
    public static void main(String[] args) {
        String s = "[](){}";
        System.out.println(solution(s));
    }

    public static boolean isBracket(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                if (c == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if (c == '}' && stack.peek() == '{') {
                    stack.pop();
                } else if (c == ']' && stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(i) + s.substring(0, i);
            if (isBracket(str)) answer++;
        }
        return answer;
    }
}
