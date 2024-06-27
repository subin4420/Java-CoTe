package Q1;
import java.util.*;

public class prog_42576_sb {
    class Solution {
        public String solution(String[] participant, String[] completion) {
            String answer = "";
            Arrays.sort(participant);
            Arrays.sort(completion);
//         for(String ele : participant){
//             System.out.println(ele);
//         }
//         for(String ele : completion){
//             System.out.println(ele);
//         }

            for(int i=0;i<completion.length;i++){
                //System.out.println(participant[i]+" "+completion[i] + participant[i].equals(completion[i]));
                if(!participant[i].equals(completion[i])){
                    return  participant[i];
                }
            }
            return participant[completion.length];
        }
    }

}
