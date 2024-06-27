package algorithm;

public class Pgm138983 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 7,6,4};
        int answer = 0;

        int sum = 0;
        for(int i=0; i<nums.length-2; i++){
            sum+=nums[i];
            for(int j=i+1; j<nums.length-1; j++){
                sum+=nums[j];
                for(int k=j+1; k<nums.length; k++){
                    sum+=nums[k];
                    if(isPrime(sum)) answer ++;
                    sum-=nums[k];
                }
                sum-=nums[j];
            }
            sum-=nums[i];
        }

        System.out.println(answer);
    }

    public static boolean isPrime(int n){
        if(n<=1) return false;
        if(n==2) return true;
        if(n%2==0) return false;
        int sqrt = (int) Math.sqrt(n);
        for(int i=3; i<=sqrt; i+=2){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}
