import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[] visited;
    static int[] arr;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visited = new boolean[N];


        dfs(N, M, 0);
        br.close();
    }

    public static void dfs(int N, int M, int depth) {
        if (depth == M) {
            for(int i = 0; i < M-1; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.print(arr[M-1]);
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
        return ;
    }

}