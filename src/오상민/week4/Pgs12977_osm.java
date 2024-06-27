class Solution {
    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int n = j + 1; n < nums.length; n++) {
                    int tmp = nums[i] + nums[j] + nums[n];
                    if (isPrime(tmp)) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}