package algo4.타겟넘버;

public class Pgs43165 {
    public int solution(int[] numbers, int target) {
        return backtrack(0, 0, numbers, target);
    }

    // cur: 지금까지 더한 숫자
    int backtrack(int cur, int idx, int[] numbers, int target) {
        // basecase
        if(idx == numbers.length) { //끝까지 올 때까지
            if(target == cur){
                return 1;
            }
            return 0;
        }

        // recursive call
        int cnt = 0;
        cnt += backtrack(cur+numbers[idx], idx+1, numbers, target);
        cnt += backtrack(cur-numbers[idx], idx+1, numbers, target);
        return cnt;
    }
}
