package 공희진.week5.회;


import java.util.*;

//더맵게
public class pgs42626_hj {
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        System.out.println(solution(scoville, K));
    }
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(); // 우선순위 큐 -> 오름차순


        for (int s : scoville) {
            queue.offer(s);
        }

        // 가장 작은 값이 k보다 작을 경우
        while (queue.peek() < K) {
            if (queue.size() == 1) { // 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우 -> size가 1인 경우
                return -1;
            }
            int first = queue.poll();
            int second = queue.poll();
            int newScoville = first + second * 2;
            queue.offer(newScoville);
            answer++;
        }

        return answer;

        //Iterator<Integer> iterator = queue.iterator();
//        while(iterator.hasNext()) {
//            int element = iterator.next();
//            int sum = 0;
//            if(element >= k) {
//                break;
//            } else {
//                int first = queue.poll();
//                int second = queue.poll();
//                sum = first + second*2;
//                queue.add(sum);
//                answer++;
//            }
//        }

    }
}

