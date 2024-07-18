package algorithm.week7;
//피로도
public class pgs140902_hj {
    public static int answer;
    private static boolean[] visited;

    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        System.out.println(solution(k, dungeons)); // 결과: 3
    }

    public static int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        answer = 0;
        backtrack(k, dungeons, 0);
        return answer;
    }

    public static void backtrack(int k, int[][] dungeons, int depth) {
        if (depth > answer) {
            answer = depth;
        }

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                backtrack(k - dungeons[i][1], dungeons, depth + 1);

                visited[i] = false;
            }
        }
    }
}
