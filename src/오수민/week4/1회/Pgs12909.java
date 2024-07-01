package Stack;

import java.util.ArrayList;

public class Prgm12909 {
    public static void main(String[] args) {
        boolean answer = true;
        String s = "()()";
        char[] arr = s.toCharArray();
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == '(') {
                list.add("(");
            }
            else if(arr[i] == ')') {
                if(list.isEmpty()){
//                    )로 시작하면 무조건 false
                    answer = false;
                    break;
                }
                list.remove("(");
            }
        }
        if(!list.isEmpty()) {
            answer = false;
        }
    }
}
