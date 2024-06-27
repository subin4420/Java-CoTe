package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class psg138984_hj {
    public static void main(String[] args) {
        int[] d = {2,2,3,3};
        int budget = 10;
        System.out.println(solution(d, budget));
    }

    public static int solution(int[] d,int budget) {
        int answer = 0;
        int sum = 0;

        Arrays.sort(d); //수가 작은것부터 더해야 최대한

        for(int i=0; i < d.length; i++) {
            sum+=d[i];
            if(sum > budget) { // 더했는데 budget보다 크면 i까지만 지원 가능
                answer = i;
                break;
            }
        }
        if(sum <= budget) { // 다 더했는데도 budget보다 작으면 모든 부서 지원 가능
            answer = d.length;
        }

        return answer;
    }
}
