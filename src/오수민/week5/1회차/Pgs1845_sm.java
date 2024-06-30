package week5;

import java.util.HashMap;

public class Pgs1845_sm {
    public static void main(String[] args) {
        int[] nums = {3,1,2,3};
        int answer = 0;

        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int n:nums){
            hm.put(n, hm.getOrDefault(n, 0) + 1);
        }
        int n = nums.length / 2;

        int max = hm.size();
        if(max>n) answer = n;
        else answer = max;

        System.out.println(answer);
    }
}
