//폰켓몬
package Programmers;

import java.util.HashSet;

public class pgs1845 {
    static class Solution {
        public int solution(int[] nums) {
            HashSet<Integer> hs = new HashSet<>();

            for(int i : nums) {
                hs.add(i);
            }

            if(hs.size() > (nums.length/2)) {
                return (nums.length/2);
            }

            return hs.size();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{3,3,3,2,2,4};

        System.out.println(solution.solution(nums));
    }
}
