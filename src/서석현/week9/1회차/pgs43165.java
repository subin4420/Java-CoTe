//타겟 넘버
package Programmers;

public class pgs43165 {
    static class Solution{
        public int solution(int[] numbers, int target){
            return dfs(numbers, target, 0, 0);
        }

        int dfs(int[] numbers, int target, int index, int ct){
            if(index == numbers.length){
                return (ct == target) ? 1 : 0;
            }

            int sum = 0;
            sum += dfs(numbers, target, index + 1, ct + numbers[index]);
            sum += dfs(numbers, target, index + 1, ct - numbers[index]);

            return sum;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] numbers = new int[]{4,1,2,1};
        int target = 4;

        System.out.println(solution.solution(numbers, target));
    }
}
