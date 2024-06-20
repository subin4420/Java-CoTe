package Algorithm.silver5;

import java.math.BigInteger;
import java.util.Scanner;

public class boj10826_osm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n < 2) {
            System.out.println(n);
        } else {
            BigInteger fibo[] = new BigInteger[n+1];
            fibo[0] = new BigInteger("0");
            fibo[1] = new BigInteger("1");
            for (int i = 2; i < fibo.length; i++) {
                fibo[i] = fibo[i - 1].add(fibo[i-2]);
            }
            System.out.print(fibo[n]);
        }
    }
}
