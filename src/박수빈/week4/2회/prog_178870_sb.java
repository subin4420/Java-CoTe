package Q1;

public class prog_178870_sb {

    class Solution {
        public int[] solution(int[] sequence, int k) {
            int minlen = Integer.MAX_VALUE;
            int[] result = new int[2];
            int start = 0;
            int end =0;
            int sum = 0;
            int seqlen = sequence.length;
            //end 인덱스가 마지막에 도차하면 종료
            while(end<seqlen){
                sum += sequence[end];
                //end인덱스의 값이 더하기
                //이 합이 k보다 작다면 뒤로 한 번 더간다.
                while(sum>k && start<=end){
                    //sum이 크다면 뒤에 start 인덱스를 줄여서 길이를 줄인다.
                    sum -= sequence[start];
                    start++;
                }
                if(sum==k){
                    if(minlen>end-start){
                        minlen=end-start;
                        result[0] = start;
                        result[1] = end;
                    }

                }

                end++;
            }

            return result;
        }
    }


}
