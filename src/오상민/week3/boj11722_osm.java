package Algorithm.silver2;

import java.util.Arrays;
import java.util.Scanner;

public class boj11722_osm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        int len[] = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            len[i] = 1;
            for (int j = arr.length - 1; j >= 0; j--) {
                if (arr[j] < arr[i] && len[j] + 1 > len[i]) {
                    len[i] = len[j] + 1;
                }
            }
        }
        Arrays.sort(len);
        System.out.println(len[len.length - 1]);
    }
}
//6
//10 20 10 30 20 50
// 1 2  1  3  2  4