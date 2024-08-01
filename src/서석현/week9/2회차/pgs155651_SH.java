//호텔 대실
package Programmers;

public class pgs155651_SH {
    static class Solution {
        private static final int MAX_TIME = 1_450; // 24*60 + 10;
        private static final int HOUR = 60;
        private static final int CLEAN_TIME = 10; // 청소시간

        public static int solution(String[][] book_time) {
            int answer = 0;

            int[] rooms = new int[MAX_TIME];

            for (String[] time : book_time) {
                String inTime = time[0];
                String outTime = time[1];

                rooms[calTime(inTime)] += 1; // 입실 시간
                rooms[calTime(outTime) + CLEAN_TIME] += -1; // 퇴실 + 청소 시간
            }

            // 누적합
            for (int i = 1; i < MAX_TIME; i++) {
                rooms[i] += rooms[i-1];
                answer = Math.max(answer, rooms[i]);
            }

            return answer;
        }

        private static int calTime(String time){
            String[] split = time.split(":");
            String hour = split[0];
            String minute = split[1];
            return ((Integer.parseInt(hour) * HOUR) + Integer.parseInt(minute));
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 테스트 케이스
        String[][] book_time = {
                {"15:00", "17:00"},
                {"16:40", "18:20"},
                {"14:20", "15:20"},
                {"14:10", "19:20"},
                {"18:20", "21:20"}
        };

        System.out.println(solution.solution(book_time));
    }
}
