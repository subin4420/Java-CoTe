import java.util.*;
class Solution {
    boolean solution(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i)+"");
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.size() == 0? true: false;
    }
    
}

// queue 풀이

import java.util.*;
class Solution {
    boolean solution(String s) {
        Queue<Character> q = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                q.add(s.charAt(i));
            }
            else {
                if (!q.isEmpty() && q.peek() == '(') {
                    q.poll();
                }
                else {
                    return false;
                }
            }
        }
        return q.isEmpty() ? true : false;
    }
    
}