package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class pgs12906_hj {
    public static void main(String[] args) {
        int[] num = {1,1,3,3,0,1,1};
        System.out.println(solution(num));
    }

    public static String solution(int[] arr) {
        int[] answer;

        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < arr.length; i++) {
            if(i==0) { // 첫번째 값은 무조건 넣어줌
                st.push(arr[i]);
            } else {
                if(st.peek() != arr[i]) { // stack의 최상단 값과 값이 다를경우 넣어줌
                    st.push(arr[i]);
                }
            }
        }

        answer = new int[st.size()];
        for(int i = st.size()-1; i >= 0; i--) {
            //stack의 최상단 값부터 answer에 넣어줌
            answer[i] = st.pop();
        }


        return Arrays.toString(answer);
//        return answer;
    }

}
