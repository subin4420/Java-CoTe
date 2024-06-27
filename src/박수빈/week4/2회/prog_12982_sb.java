package Q1;
import java.util.Arrays;

public class prog_12982_sb {
    class Solution {
        public int solution(int[] d, int budget) {
            int answer = 0;
            Arrays.sort(d);
            int i =0;
            for(i=0;i<d.length;i++){
                System.out.println(d[i]+"- budg("+budget+") = "+ (budget-d[i]));
                if(budget-d[i]>0){
                    budget -=d[i];
                }
                else if(budget-d[i]==0){
                    answer = i+1;
                    return answer;
                }
                else{
                    System.out.print(i-1);
                    answer = i;
                    return answer;
                }
            }


            return i;
        }
    }
}
