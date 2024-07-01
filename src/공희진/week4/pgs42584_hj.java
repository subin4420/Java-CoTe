package algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class pgs42584_hj {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        System.out.println(solution(prices));
    }

    public static String solution(int[] prices) {
//        int[] answer = new int[prices.length];
//
//        for (int i = 0; i < prices.length; i++) { // prices[i] 기준으로 순회
//            for (int j = i + 1; j < prices.length; j++) {
//                if (prices[i] >= prices[j]) { // 가격이 떨어지지 않은 경우
//                    answer[i]++;
//                    if (prices[i] > prices[j])
//                        break; // 가격이 떨어지는 경우
//                }
//            }
//
//        }
//        return answer;

        Queue<Integer> queue = new LinkedList<>();
        int[] answer = new int[prices.length];

        for(int i = 0; i < prices.length; i++) {
            queue.offer(prices[i]);
        }

        int index = 0;
        while (!queue.isEmpty()) {
            int currentPrice = queue.poll();
            // currentPrice 기준으로 다음 가격들을 비교
            for (int i = (prices.length - queue.size()); i < prices.length; i++) {
                // 가격이 떨어 졌을 경우
                if (currentPrice > prices[i]) {
                    answer[index]++;
                    break;
                }
                // 가격이 떨어지지 않았을 경우
                if (currentPrice <= prices[i]) {
                    answer[index]++;
                }
            }
            index++;
        }
        return Arrays.toString(answer);
    }
}
