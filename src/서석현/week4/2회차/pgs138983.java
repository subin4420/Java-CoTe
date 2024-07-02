package Programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class pgs138983 {
    static class Solution {
        public int solution(int[] nums) {
            int cnt = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    for (int k = j + 1; k < nums.length; k++) {
                        if (isPrime(nums[i] + nums[j] + nums[k])) {
                            cnt++;
                        }
                    }
                }
            }
            return cnt;
        }

        public static boolean isPrime(int num) {
            if (num <= 1) return false;
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) return false;
            }
            return true;
        }
    }


            //소수를 미리 구하고 비교한 풀이
//            ArrayList<Integer> prime = new ArrayList<>();
//
//            int n = 3000;
//
//            for(int i = 2; i < n; i++){
//                boolean isPrime = true;
//                for(int j = 2; j * j <= i; j++){
//                    if(i % j == 0) {
//                        isPrime = false;
//                        break;
//                    }
//                }
//                if(isPrime) {
//                    prime.add(i);
//                }
//            }
//
//            int cnt = 0;
//            for(int i = 0; i < nums.length; i ++) {
//                for(int j = i + 1; j < nums.length; j ++) {
//                    for(int k = j + 1; k < nums.length; k++) {
//                        if(prime.contains(nums[i] + nums[j] + nums[k])){
//                            cnt++;
//                        }
//                    }
//                }
//            }
//            return cnt;
//        }
//    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,7,6,4};

        System.out.println(solution.solution(nums));
    }
}
