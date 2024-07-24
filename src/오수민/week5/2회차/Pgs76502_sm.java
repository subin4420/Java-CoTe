package codechallenge2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Pgs76502 {
    public static void main(String[] args) {
        String s = "}}}";
        int answer = 0;

        Queue<String> q = new LinkedList<String>();
        String[] git sArr = s.split("");
        for(String i:sArr){
            q.add(i);
        }

        Stack<String> st = new Stack<>();
        for(int a=0;a<q.size();a++){
            String first = q.peek();
            if(first.equals("[")||first.equals("{")||first.equals("(")){
                for(String i:q){
                    if(i.equals("[")||i.equals("{")||i.equals("(")){
                        st.push(i);
                    }
                    else if(st.isEmpty()){
                        continue;
                    }
                    if(i.equals("]")){
                        String tmp = st.peek();
                        if(tmp.equals("[")){
                            st.pop();
                        }
                    }
                    else if(i.equals("}")){
                        String tmp = st.peek();
                        if(tmp.equals("{")){
                            st.pop();
                        }
                    }
                    else if(i.equals(")")){
                        String tmp = st.peek();
                        if(tmp.equals("(")){
                            st.pop();
                        }
                    }
                }
                if(st.isEmpty()){
                    answer++;
                }
                st.clear();
            }
            String tmp = q.poll();
            q.add(tmp);
        }

        System.out.println(answer);
    }
}
