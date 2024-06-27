package Programmers;

import java.util.ArrayList;

public class pgs138983 {
    public static void main(String[] args) {
        ArrayList<Integer> sum = new ArrayList<>();

        int[] nums = {1, 5, 6, 7, 8, 10, 12, 13, 15};

        for(int i = 0; i < nums.length; i ++) {
            for(int j = i + 1; j < nums.length; j ++) {
                for(int k = j + 1; k < nums.length; k++) {
                    sum.add(nums[i] + nums[j] + nums[k]);
                }
            }
        }

        int primeCount = 0;
        for (int number : sum) {
            if (isPrime(number)) {
                primeCount++;
            }
        }

        System.out.println("Sum list: " + sum);
        System.out.println("Number of primes: " + primeCount);
    }

    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {     //Math.sqrt(num) = num의 제곱근 구하는 코드
            if (num % i == 0) return false;
        }
        return true;
    }
}
