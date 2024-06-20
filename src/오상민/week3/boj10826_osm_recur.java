package Algorithm.silver5;

import java.util.Scanner;

public class boj10826_osm_recur {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        System.out.println(fibo(i));

    }

    public static int fibo(int x) {
        if (x < 2) {
            return x;
        } else {
            return fibo(x - 1) + fibo(x - 2);
        }
    }
}
