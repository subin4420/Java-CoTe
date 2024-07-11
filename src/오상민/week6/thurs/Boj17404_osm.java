/**
 * RGB거리 2
 */

import java.util.Scanner;

public class Boj17404_osm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] r = new int[n];
        int[] g = new int[n];
        int[] b = new int[n];
        int dpR[][] = new int[3][n];
        int dpG[][] = new int[3][n];
        int dpB[][] = new int[3][n];

        for (int i = 0; i < n; i++) {
            r[i] = scanner.nextInt();
            g[i] = scanner.nextInt();
            b[i] = scanner.nextInt();
        }

        //첫집 빨강일때 초기화
        dpR[0][0] = r[0];
        dpR[1][0] = 1001;
        dpR[2][0] = 1001;

        for (int i = 1; i < n - 1; i++) {
            dpR[0][i] = Math.min(dpR[1][i - 1], dpR[2][i - 1]) + r[i];
            dpR[1][i] = Math.min(dpR[0][i - 1], dpR[2][i - 1]) + g[i];
            dpR[2][i] = Math.min(dpR[0][i - 1], dpR[1][i - 1]) + b[i];
        }

        //첫집 빨강일때 마지막 g, b 경우의 수
        int rMin1 = g[n - 1] + Math.min(dpR[0][n - 2], dpR[2][n - 2]);
        int rMin2 = b[n - 1] + Math.min(dpR[0][n - 2], dpR[1][n - 2]);
        int finalRed = Math.min(rMin1, rMin2);

        dpG[0][0] = 1001;
        dpG[1][0] = g[0];
        dpG[2][0] = 1001;

        for (int i = 1; i < n - 1; i++) {
            dpG[0][i] = Math.min(dpG[1][i - 1], dpG[2][i - 1]) + r[i];
            dpG[1][i] = Math.min(dpG[0][i - 1], dpG[2][i - 1]) + g[i];
            dpG[2][i] = Math.min(dpG[0][i - 1], dpG[1][i - 1]) + b[i];
        }
        int gMin1 = r[n - 1] + Math.min(dpG[1][n - 2], dpG[2][n - 2]);
        int gMin2 = b[n - 1] + Math.min(dpG[0][n - 2], dpG[1][n - 2]);
        int finalGreen = Math.min(gMin1, gMin2);

        dpB[0][0] = 1001;
        dpB[1][0] = 1001;
        dpB[2][0] = b[0];

        for (int i = 1; i < n - 1; i++) {
            dpB[0][i] = Math.min(dpB[1][i - 1], dpB[2][i - 1]) + r[i];
            dpB[1][i] = Math.min(dpB[0][i - 1], dpB[2][i - 1]) + g[i];
            dpB[2][i] = Math.min(dpB[0][i - 1], dpB[1][i - 1]) + b[i];
        }
        int bMin1 = r[n - 1] + Math.min(dpB[1][n - 2], dpB[2][n - 2]);
        int bMin2 = g[n - 1] + Math.min(dpB[0][n - 2], dpB[2][n - 2]);
        int finalBlue = Math.min(bMin1, bMin2);

        System.out.println(Math.min(finalRed, Math.min(finalGreen, finalBlue)));
    }
}
/**
 * 26 1000 1000
 * 1049 86 83
 * x 83+89 86+89
 * <p>
 * 1001 40 1001
 * 89 1063 97
 * 97+13 x 97+99
 */
