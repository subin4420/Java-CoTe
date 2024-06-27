package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class psg138983_hj {
    public static void main(String[] args) {
        int[] nums = {1,2,7,6,4};
        System.out.println(solution(nums));
    }

    public static boolean isPrime(int num) { // 소수 판별
        if(num == 1) return false;
        for(int i = 2; i < num; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }

    public static int solution(int[] nums){
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i = 0; i< nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if(isPrime(sum)) {
                        list.add(sum);
                    }
                }
            }
        }

        answer = list.size();


        return answer;
    }


}
