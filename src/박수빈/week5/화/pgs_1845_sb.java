package cote_0701;
import java.util.*;
//폰켓몬
public class pgs_1845 {
    class Solution {
        public int solution(int[] nums) {
            int answer = 0;
            HashSet<Integer> hs = new HashSet<>();
            for(int e : nums){
                hs.add(e);
            }
            System.out.println(hs);
            if(hs.size()>nums.length/2){
                return nums.length/2;
            }
            else{
                return hs.size();
            }
        }
    }
}
