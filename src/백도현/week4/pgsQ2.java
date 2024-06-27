import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i+1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (isPrime(nums[i] + nums[j] + nums[k]))
                        answer++; 
                }
            }
        }

        

        return answer;
    }
    
    public boolean isPrime(int n) {
        if (n == 1) return false;
        if (n == 2 || n == 3) return true;
        int i = 2;
        while (i * i <= n) {
            if (n % i == 0) {
                return false;
            }
            i++;
        }
        return true;
        
    }
}