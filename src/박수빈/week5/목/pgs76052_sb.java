package cote_0701;
import java.util.*;
//괄호 회전하기
public class pgs76052_sb {

    class Solution {
        public int solution(String s) {
            int answer = 0;
            char[] c = s.toCharArray();
            Queue<Character> q = new LinkedList<>();
            for (char cc : c) {
                q.add(cc);
            }

            for (int i = 0; i < c.length; i++) {
                if (isValid(q)) {
                    answer++;
                }
                q.add(q.poll());
            }

            return answer;
        }

        static boolean isValid(Queue<Character> q) {
            Stack<Character> stack = new Stack<>();
            for (Character ch : q) {
                if (ch == '[' || ch == '{' || ch == '(') {
                    stack.push(ch);
                } else if (ch == ')' && !stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else if (ch == '}' && !stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                } else if (ch == ']' && !stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            }
            return stack.isEmpty();
        }
    }

}
/*
*
    static int small = 0;
    static int big = 0;
    static int middle = 0;
    static int flag = 0;

    public static int solution(String s) {
        int answer = 0;
        char[] c = s.toCharArray();
        Queue<Character> q = new LinkedList<>();
        for(char cc : c){
            q.add(cc);
        }
        System.out.println(q);
        for(int i = 0; i < c.length; i++){
            for(Character ch:q){
                cnt(ch);
                if(big==0&&flag!=0){

                }
                else if(middle==0&&flag!=0){

                }
                else if(small==0&&flag!=0){

                }


                if(big<0){
                    break;
                }
                else if(small<0){
                    break;
                }
                else if(middle<0){
                    break;
                }
            }
            if(big==0&&middle==0&&small==0){
                answer++;
            }
            big = 0;
            middle = 0;
            small = 0;
            q.add(q.poll());
        }

        return answer;
    }
    static void cnt(Character ch) {
        if(ch == '['){
            big++;
            if(flag == 1){
                flag = 0;
            }else{
                flag = 1;
            };
        }
        else if(ch == '{'){
            middle++;
            if(flag == 1){
                flag = 0;
            }else{
                flag = 1;
            };
        }
        else if(ch == '('){
            small++;
            if(flag == 1){
                flag = 0;
            }else{
                flag = 1;
            };
        }
        else if(ch == ')'){
            small--;
            if(flag == 1){
                flag = 0;
            }else{
                flag = 1;
            };
        }
        else if(ch == '}'){
            middle--;
            if(flag == 1){
                flag = 0;
            }else{
                flag = 1;
            };
        }
        else if(ch == ']') {
            big--;
            if(flag == 1){
                flag = 0;
            }else{
                flag = 1;
            };
        }
    }

*/