package algorithm;

import java.util.Arrays;

public class Pgm138984 {
    public static void main(String[] args) {
        int[] d = {2,2,3,3};
        int budget = 9;
        int answer = d.length;

        int d_sum = 0;
        Arrays.sort(d);
        for(int i = 0; i < d.length; i++) {
            d_sum += d[i];
            if(d_sum > budget){
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }
}
