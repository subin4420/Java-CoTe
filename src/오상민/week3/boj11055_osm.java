package Algorithm.silver2;

import java.util.Scanner;
import java.util.Arrays;

public class boj11055_osm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        int sum[] = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        for (int i = 0; i < arr.length; i++) {
            sum[i] = arr[i];
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] < arr[i] && sum[j] + arr[i] > sum[i]) {
                    sum[i] = sum[j] + arr[i];
                }
            }
        }
        Arrays.sort(sum);
        System.out.println(sum[sum.length - 1]);
    }
}
