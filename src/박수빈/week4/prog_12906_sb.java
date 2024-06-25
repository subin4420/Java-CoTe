package Q1;
import java.util.*;

public class prog_12906 {

    public class Solution {
        public int[] solution(int []arr) {
            int j =1;
            Stack<Integer> stack = new Stack<>();
            for(int i=0;i<arr.length;i++){
                if(stack.isEmpty() || arr[i]!=stack.peek()){
                    stack.push(arr[i]);
                }
            }
            int[] answer = new int[stack.size()];
            //System.out.println(stack);
            //System.out.println(stack.size());
            int size = stack.size();
            for(int i=0;i<size;i++)
            {
                //System.out.println(stack.pop());
                answer[size-1-i]=stack.pop();
            }
            // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
            //System.out.println(stack);

            return answer;
        }
    }
}
