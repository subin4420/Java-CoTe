package BaeJoon;

import java.util.Scanner;

public class boj15649 {
    static int n, m;
    static int[] selected;  // 선택한 숫자를 저장할 배열
    static boolean[] used;  // 숫자가 사용되었는지 여부를 체크하는 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        selected = new int[m];
        used = new boolean[n + 1];
        sc.close();

        backtrack(0);  // 깊이 0에서 시작
    }

    public static void backtrack(int depth) {
        if (depth == m) {  // 깊이가 M과 같으면
            for (int i = 0; i < m; i++) {
                System.out.print(selected[i] + " ");  // 선택된 숫자 출력
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!used[i]) {  // i가 사용되지 않았다면
                selected[depth] = i;  // 현재 깊이에 숫자 i 선택
                used[i] = true;  // 숫자 i를 사용했다고 표시
                backtrack(depth + 1);  // 다음 깊이로 이동
                used[i] = false;  // 숫자 i를 다시 사용할 수 있도록 표시 해제
            }
        }
    }
}
