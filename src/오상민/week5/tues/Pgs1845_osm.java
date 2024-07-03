import java.util.*;

/**
 * 폰켓몬
 */

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int select = nums.length / 2;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        if (set.size() > select) {
            return select;
        } else {
            return set.size();
        }
    }
}