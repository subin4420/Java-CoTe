package kakao2020;

import java.util.LinkedList;
import java.util.Queue;

public class Pgs60057_sm {
    public static void main(String[] args) {
        String s = "ababcdcdababcdcd";

        int answer = s.length();
        int max = answer/2;

        String[] sArr = s.split("");
        int len = 1;

        while(len<=max){
            //큐 생성
            Queue<String> q = new LinkedList<>();
            for(int i=0;i<sArr.length;i+=len){
                String tmp = "";
                for(int j=0;j<len;j++){
                    if(i+j>=sArr.length) break;
                    tmp += sArr[i+j];
                }
                q.add(tmp);
            }
            ///

            int i=0,j=0;
            String str="",next="", changed="";
            int size = q.size();
            while(next!=null){
                str = q.poll();
                int cnt=1;
                while(true){
                    next = q.peek();
                    if(str.equals(next)){
                        q.poll();
                        cnt++;
                    }else{
                        if(cnt==1) changed+=str;
                        else{
                            changed+=cnt;
                            changed+=str;
                        }
                        break;
                    }
                }
            }
            if(answer>changed.length()) answer=changed.length();
            len++;
        }

        System.out.println(answer);
    }
}
