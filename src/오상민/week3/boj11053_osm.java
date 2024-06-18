package Algorithm.silver2;

import java.util.Arrays;
import java.util.Scanner;

public class boj11053_osm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        int len[] = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        for (int i = 0; i < arr.length; i++) {
            len[i] = 1;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] < arr[i] && len[j] + 1 > len[i]) {
                    len[i] = len[j] + 1;
                }
            }
        }
        Arrays.sort(len);
        System.out.println(len[len.length - 1]);
    }
}
