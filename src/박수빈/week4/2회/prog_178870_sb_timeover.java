package Q1;

public class prog_178870_sb_timeover {
    class Solution {
        public int[] solution(int[] sequence, int k) {
            int[] answer = {};
            int[] sum = new int[sequence.length];
            int[] shortArr = new int[2];
            int shortlen = -1;
            sum[0] = sequence[0];
            int len=sum.length;
            for(int i=1;i<len;i++){
                sum[i] = sum[i-1] + sequence[i];
            }//N
            if(k==sum[0]){
                return new int[]{0,0};
            }
            for(int i=0;i<len;i++){
                for(int j=0; j<i;j++){
                    if(k==sum[i]){
                        shortlen = i+1;
                        shortArr[0] = 0;
                        shortArr[1] = i;
                    }

                    if(k==sum[i]-sum[j]){
                        if(shortlen==-1){
                            shortlen = i-j;
                            shortArr[0] = j+1;
                            shortArr[1] = i;
                        }
                        else if(shortlen>i-j){
                            shortlen = i-j;
                            shortArr[0] = j+1;
                            shortArr[1] = i;
                        }
                    }
                }
            }
            return shortArr;
        }
    }
}
