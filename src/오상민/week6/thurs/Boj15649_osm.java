/**
 * N 과 M
 */

import java.util.Scanner;

public class Boj15649_osm {

    static int[] arr;
    static boolean[] visited;

    static void dfs(int N, int M, int depth) {
        if (depth == M) {
            for (int value : arr) {
                System.out.print(value + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i + 1;
                dfs(N, M, depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        arr = new int[m];
        visited = new boolean[n];
        dfs(n, m, 0);
    }
}
