// import java.util.*;
// class Solution {
//     public int solution(String[][] book_time) {
//         int answer = 0;
//         Arrays.sort(book_time, new Comparator<String[]>() {
//             @Override
//             public int compare(String[] o1, String[] o2) {
//                 if(o1[0].toString().contentEquals(o2[0].toString()))
//                     return o1[1].toString().compareTo(o2[1].toString());
//                 else
//                     return o1[0].toString().compareTo(o2[0].toString());
//             }
//         });
//         List<List<String[]>> list = new ArrayList<>();
//         List<String[]> newList = new ArrayList<>();
//         newList.add(book_time[0]);
//         list.add(new ArrayList<>(newList));
//         for (int i = 1; i < book_time.length; i++) {
//             String[] now = book_time[i];
//             boolean flag = false;

//             for (List<String[]> x : list) {
//                 String[] tmp = x.get(x.size()-1);
//                 flag = isPossible(tmp, now);
//                 if (flag) {
//                     x.add(now);
//                     break;
//                 }
//             }
//             if (!flag) {
//                 List<String[]> l = new ArrayList<>();
//                 l.add(now);
//                 list.add(l);
//             }
//         }
//         return list.size();
//     }

//     public boolean isPossible(String[] x, String[] y) {
//         int h = Integer.parseInt(y[0].substring(0, 2)) - 
//                     Integer.parseInt(x[1].substring(0, 2));
//         h *= 60;
//         h += Integer.parseInt(y[0].substring(3, 5)) - 
//                     Integer.parseInt(x[1].substring(3, 5));
//         return h >= 10;
//     }
// }

import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        Arrays.sort(book_time, (x, y) -> x[0].compareTo(y[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        
        
        for (String[] arr : book_time) {
            int start = Integer.parseInt(arr[0].split(":")[0])*60 + Integer.parseInt(arr[0].split(":")[1]);
            int end = Integer.parseInt(arr[1].split(":")[0])*60 + Integer.parseInt(arr[1].split(":")[1]);
            
            if (pq.isEmpty()) {
                answer++;
                pq.offer(new int[]{start, end});
                continue;
            }
            
            int[] prev = pq.poll();
            if (start >= prev[1] + 10) {
                pq.offer(new int[]{start, end});
            } else {
                answer++;
                pq.offer(new int[]{start, end});
                pq.offer(prev);
            }
            
            
        }
        return answer;
    }
}