import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        int fin = 100;
        int[] day = new int[speeds.length];
        for (int i = 0; i < speeds.length; i++) {
            int tmp = (fin - progresses[i]) / speeds[i];
            if ((fin - progresses[i]) % speeds[i] != 0) {
                tmp += 1;
            }
            day[i] = tmp;
        }
        int last = day[0];
        int count = 1;
        for (int i = 1; i < day.length; i++) {
            if (last >= day[i]) {
                //한번에 배포
                count++;
            } else {
                //배포 넘김
                list.add(count);
                count = 1;
                last = day[i];
            }
        }
        list.add(count);
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}