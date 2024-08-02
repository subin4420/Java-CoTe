/**
 * 호텔 대실
 */

import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int[][] bookTime = new int[book_time.length][book_time[0].length];
        for (int i = 0; i < book_time.length; i++) {
            int start = Integer.parseInt(book_time[i][0].replace(":", ""));
            int end = Integer.parseInt(book_time[i][1].replace(":", ""));

            end += 10;

            if (end % 100 >= 60) {
                end += 40;
            }

            bookTime[i][0] = start;
            bookTime[i][1] = end;
        }

        Arrays.sort(bookTime, (a1, a2) -> {
            return a1[0] - a2[0];
        });

        PriorityQueue<int[]> que = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        for (int[] book : bookTime) {
            if (que.isEmpty()) {
                que.add(book);
            } else {
                int[] tmp = que.peek();
                if (tmp[1] <= book[0]) {
                    que.poll();
                }
                que.add(book);
            }
        }
        return que.size();
    }
}