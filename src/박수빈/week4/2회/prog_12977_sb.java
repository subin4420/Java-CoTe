package Q1;

public class prog_138983_sb {
    class Solution {
        public int solution(int[] nums) {
            int answer = 0;
            int len = nums.length;
            int sum = 0;
            // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
            for(int i=0;i<len-2;i++){
                System.out.print(nums[i]+", ");
            }
            for(int i=0; i<len-2;i++){
                for(int j=1+i; j<len-1;j++){
                    for(int k=1+j;k<len;k++){
                        sum=nums[i]+nums[j]+nums[k];
                        if(isPrime(sum)){
                            answer++;
                        }
                    }
                }
            }
            return answer;
        }
        boolean isPrime(int sum){
            for(int i=2;i<sum/2;i++){
                if(sum%i==0){
                    return false;
                }
            }
            return true;
        }

    }
}
