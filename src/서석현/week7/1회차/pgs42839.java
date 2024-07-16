//소수 찾기
package Programmers;

import java.util.*;

public class pgs42839 {

    static class Solution {
        public static boolean[] visited;
        public static HashSet<Integer> set;
        public static int[] numArr;

        public static int solution(String numbers) {
            numArr = new int[numbers.length()];
            for (int i = 0; i < numbers.length(); i++) {
                numArr[i] = Integer.parseInt(String.valueOf(numbers.charAt(i)));
            }
            set = new HashSet<>();
            backtrack(numArr, new boolean[numbers.length()], "");

            int answer = 0;
            for (int num : set) {
                if (isPrime(num)) {
                    answer++;
                }
            }
            return answer;
        }

        public static void backtrack(int[] numArr, boolean[] visited, String str) {
            if (!str.isEmpty()) {
                set.add(Integer.parseInt(str));
            }

            for (int i = 0; i < numArr.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    backtrack(numArr, visited, str + numArr[i]);
                    visited[i] = false;
                }
            }
        }

        public static boolean isPrime(int num) {
            if (num <= 1) {
                return false;
            }
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String num = "011";

        System.out.println(solution.solution(num));
    }
}
