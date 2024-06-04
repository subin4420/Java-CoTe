package cote;

import java.util.Arrays;
import java.util.Scanner;

public class 구간합구하기4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        int[] array = new int[n];
        for(int i=0; i<array.length; i++) {
            array[i] = sc.nextInt();
        }

        //누적합 담을 배열 선언
        int[] dp = new int[n+1];
        //임의로 dp[0] = 0 으로 초기화
        dp[0] =0;

        //dp[1] 부터 누적합 저장
        for(int i=1; i < dp.length; i++){
           dp[i] = dp[i-1] + array[i-1];
        }

        int sum = 0;
        //구간합
        for(int t = 0; t < m; t++) {
            //sum 초기화
            sum = 0;

            int i = sc.nextInt();
            int j = sc.nextInt();

            //i부터 j까지의 누적합 계산
            sum = dp[j]-dp[i-1];

            System.out.println(sum);
        }


    }
}
