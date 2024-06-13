package cote;

import java.util.Arrays;
import java.util.Scanner;

public class 주몽_1940 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        //받아온 N으로 배열 생성
        int[] arr = new int[N];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        //배열 정렬 1 2 3 4 5 7
        Arrays.sort(arr);

        //배열 기준으로 양쪽에 선언
        int start = 0;
        int end = N - 1;
        int cnt = 0;

        //start가 end보다 클 경우 중단
        while (start < end) {
            if (arr[start] + arr[end] < M) {
                start++;
            } else if (arr[start] + arr[end] == M ) {
                cnt++;
                end--;
                start++;
            } else { // > N
                end--;
            }
        }

//        System.out.println(Arrays.toString(arr));
        System.out.println(cnt);
    }
}
