package algorithm;

import java.util.Stack;

public class pgs12909_hj {
    public static void main(String[] args) {
        String s = ")()(";
        System.out.println(solution(s));
    }

    public static boolean solution(String s) {
        boolean answer = true;
        Stack<Character> st = new Stack<>();

        for (Character c : s.toCharArray()) {
            // s의 문자를 하나씩 돌면서 열린괄호만 스택에 추가하고 닫힌괄호만나면 스택에 있는 열린괄호 제거하면서 짝이 맞는지 확인
            if (c == '(') {
                st.push(c); // 열린 괄호 스택에 추가
            } else { // s의 문자가 ')'인 경우
                if (st.isEmpty()) { //스택이 비어있는 경우
                    answer = false; // 짝이 맞지않음 false
                } else {
                    st.pop(); // 스택에 있는 열린 괄호 제거
                }
            }
        }

        if (!st.isEmpty()) { // 스택에 열린 괄호가 남아있는 경우
            answer = false;
        }

        return answer;
    }
}
