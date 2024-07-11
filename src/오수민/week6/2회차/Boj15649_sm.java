package week6.thu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj15649 {
    public static int[] arr;
    public static boolean[] visit;

    public static int N;
    public static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visit = new boolean[N];
        dfs(0);

    }

    public static void dfs(int depth) {
        if(depth == M) {
            for (int val : arr) {
                System.out.print(val+" ");
            }
            System.out.println();
            return;
        }
        for(int i = 0; i < N; i++) {
            if (visit[i] == false) {
                visit[i] = true;
                arr[depth] = i+1;
                dfs(depth+1);

                visit[i] = false;
            }
        }
    }
}
