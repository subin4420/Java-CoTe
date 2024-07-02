package 공희진.week5;
//폰켓몬
import java.util.HashMap;
import java.util.HashSet;

public class pgs1845_hj {
    public static void main(String[] args) {
        int[] nums = {3,1,2,3};
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums){
        int answer = 0;
        HashSet<Integer> set = new HashSet<>(); // 중복 제거
        int mon = nums.length/2;

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        // 3,2,4  / 3 -> 3
        // 1,2,3 / 2 -> 2
        // 3,2  / 3  -> 2
        if(mon > set.size()) {
            // 중복 제거한 set의 크기가 mon보다 작으면 set의 크기가 최대값
            answer = set.size();
        } else {
            // 중복 제거한 set의 크기가 mon보다 크거나 같으면 mon이 최대값
            answer = mon;
        }


        return answer;
    }
}
