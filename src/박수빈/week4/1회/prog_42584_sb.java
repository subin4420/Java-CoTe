package Q1;
import java.util.Stack;

public class prog_42584 {
}
class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            //현재가가 오르면 해당 인덱스 스택에 넣기
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                //현재가가 과거(스택의 peek)보다 낮으면 해당 과거 인덱스 꺼내서 현재랑 빼주기
                //스택의 최상단이 현재보다 작을 때까지 반복
                int j = stack.pop();
                //현재 - 과거 = 유지된 시간
                answer[j] = i - j;
            }
            stack.push(i);
        }
        //for문이 끝났다는건 과거 현재 비교가 끝남 스택에 남아있다면 자신의 시간부터 끝까지 하락하지 않은 경우
        while (!stack.isEmpty()) {
            int j = stack.pop();
            //하락하지 않은경우니 버틴 시간을 구해야한다. 버틴 시간 = 최대시간(n-1초) - 자기시간(본인 인덱스)
            answer[j] = n - 1 - j;
        }
        return answer;
    }
}