package algorithm.week6;

import java.util.Scanner;

public class boj15649_hj {
    static int[] arr;
    static boolean[] visit;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int M = in.nextInt();

        arr = new int[M];
        visit = new boolean[N];
        dfs(N, M, 0);

        in.close();
    }

    /*
          (root)
        /   |   \
       1    2    3

    * */

       /*
      (depth=0)
           ┌─────1──────┐
          /        |    \
(depth=1) 2        3     4
        /  \     /  \   /  \
       (2) (3)  (2)(4) (3)(4)
 (depth=2)

        * */

    public static void dfs(int N, int M, int depth) {
        if (depth == M) { // depth가 M에 도달할 경우
            for (int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            // 해당 노드를 방문하지 않았을 경우
            if (!visit[i]) {
                visit[i] = true; // 해당 노드 방문상태로 변경
                arr[depth] = i + 1; // 해당 깊이를 index로 하여 i + 1 값 저장
                dfs(N, M, depth + 1); // 다음 자식 노드 방문을 위해 depth 1 증가

                // 자식 노드 방문 끝나면 방문 하지 않은 상태로 변경
                visit[i] = false;
            }
        }
    }
}
