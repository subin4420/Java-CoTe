package Q1;
import java.util.*;

public class prog_12909 {
    class Solution {
        boolean solution(String s) {
            boolean answer = true;
            char[] cArr = s.toCharArray();
            int cnt = 0;
            Stack<Character> stack = new Stack<>();
            for(int i=0;i<cArr.length;i++)
            {
                stack.push(cArr[i]);
            }
            int size = stack.size();
            //일단 스택에 넣기
            //스택의 최상위가 맨뒤 괄호
            //맨뒤가 )와야함 0에서 시작 '('오면 -1 ')'오면 +1
            //항상 cnt가 0보다 커야함 괄호의 끝이 )이기때문에
            //만약 stack끝까지 다 돌았는데 cnt가 0이 아니다?
            //잘못된괄호짝
            while(!stack.isEmpty()){
                char charpop = stack.pop();
                if(cnt>=0){
                    if(')' == charpop){
                        cnt++;
                    }
                    else if('(' == charpop){
                        cnt--;
                    }
                }
                else{
                    answer = false;
                    return false;
                }
            }
            if(cnt!=0){
                return false;
            }

            return answer;
        }
    }
}
