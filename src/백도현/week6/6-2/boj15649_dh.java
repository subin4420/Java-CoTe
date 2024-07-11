import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[] visited;
    static List<Integer> arr;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new ArrayList<>();
        visited = new boolean[N+1];

        for (int i = 1; i <= N; i++) {
            dfs(i);
        }
        br.close();
    }

    public static void dfs(int n) {
        arr.add(n);
        visited[n] = true;
        if (arr.size() == M) {
            for(int i = 0; i < arr.size() - 1; i++) {
                System.out.print(arr.get(i) + " ");
            }
            System.out.print(arr.get(arr.size()-1));
            System.out.println();
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }
        visited[n] = false;
        arr.remove(arr.indexOf(n));
    }

}