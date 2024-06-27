package Stack;

import java.util.ArrayList;

public class Prgm42586 {
    public static void main(String[] args) {
        int[] progresses = {95, 95, 95, 95};
        int[] speeds = {4, 3, 2, 1};

//        progresses => [95, 95, 95, 95]
//        speeds => [4, 3, 2, 1]
//
//        answer => [2, 1, 1]

        int[] rest = new int[progresses.length];
        double[] days = new double[progresses.length];

        for (int i = 0; i < progresses.length; i++) {
            rest[i] = 100 - progresses[i];
            days[i] = Math.ceil((double) rest[i] / speeds[i]);
        }

        ArrayList<Integer> al = new ArrayList<>();
        int i = 0, j = 0;
        while (true) {
            int cnt = 1;
            for (j = i + 1; j < progresses.length; j++) {
                if (days[i] >= days[j]) {
                    cnt++;
                } else {
                    break;
                }
            }
            i = j;
            al.add(cnt);
            if (i == progresses.length) {
                break;
            }

        }

        int[] arr = al.stream().mapToInt(x -> x).toArray();
    }
}
