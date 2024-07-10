import java.util.Scanner;

public class boj1149_bgm {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int sum = 0;
//        int idx = -1;
//        int N = sc.nextInt();
//        int[][] color = new int[N][3];
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < 3; j++) {
//                color[i][j] = sc.nextInt();
//            }
//        }
//        for (int i = 0; i < N; i++) {
//            int min = 1000;
//            for (int j = 0; j < 3; j++) {
//                if (min > color[i][j]) {
//                    if (idx == j) {
//                        continue;
//                    }
//                    min = color[i][j];
//                    idx = j;
//                }
//            }
//            sum += min;
//        }
//        System.out.println(sum);
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] cost = new int[N][3];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                cost[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i < N; i++) {
            cost[i][0] += Math.min(cost[i - 1][1], cost[i - 1][2]);
            cost[i][1] += Math.min(cost[i - 1][0], cost[i - 1][2]);
            cost[i][2] += Math.min(cost[i - 1][0], cost[i - 1][1]);
        }
        System.out.println(Math.min(cost[N - 1][0], Math.min(cost[N - 1][1], cost[N - 1][2])));
    }
}
