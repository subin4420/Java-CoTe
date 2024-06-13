package cote;

import java.util.Scanner;

public class 수들의합5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int start =1;
        int end = 1;
        int  cnt = 1;
        int sum = 1;

        while (end != num) {
            if(sum == num) {
                cnt++;
                end++;
                sum += end;
            } else if (sum > num) {
                sum -= start;
                start ++;
            } else {
                end++;
                sum += end;
            }
        }
        System.out.println(cnt);

    }
}
