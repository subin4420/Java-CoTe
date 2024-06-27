package Programmers;

import java.util.ArrayList;

public class pgs138985 {
    static class Solution {
        public int[] solution(int[] sequence, int k) {
            ArrayList<int[]> result = new ArrayList<>(); // 결과를 저장할 리스트
            int start = 0;
            int end = 0;
            int sum = 0;

            sum += sequence[start]; // 초기값 설정

            while (true) {
                if (sum == k) { // 현재 부분 수열의 합이 k와 같을 때
                    result.add(new int[]{start, end}); // 결과 리스트에 시작과 끝 인덱스 추가
                    if (end + 1 < sequence.length) {
                        sum = sum + sequence[++end] - sequence[start++]; // 다음 요소 추가 및 시작 요소 제거
                    } else {
                        break; // 더 이상 요소가 없으면 종료
                    }
                } else if (sum < k) { // 현재 부분 수열의 합이 k보다 작을 때
                    if (end + 1 < sequence.length) {
                        sum += sequence[++end]; // 끝 요소를 확장
                    } else {
                        break; // 더 이상 요소가 없으면 종료
                    }
                } else { // 현재 부분 수열의 합이 k보다 클 때
                    sum -= sequence[start++]; // 시작 요소를 제거
                }
            }

            // 차이를 구하고 최소값 및 해당 포인터 찾기
            int minDifference = Integer.MAX_VALUE;
            int[] minDifferencePointers = new int[2];
            for (int[] pair : result) {
                int difference = Math.abs(pair[1] - pair[0]);   //Math.abs = 음수를 양수로
                if (difference < minDifference) {
                    minDifference = difference;
                    minDifferencePointers = pair; // 최소 차이인 인덱스 쌍 저장
                }
            }

            return minDifferencePointers;  // 인덱스 쌍 반환
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] seq = new int[]{1, 2, 3, 4, 5,};
        int k = 7;
        System.out.println(solution.solution(seq, k)[0] + " " + solution.solution(seq, k)[1]);
    }
}
