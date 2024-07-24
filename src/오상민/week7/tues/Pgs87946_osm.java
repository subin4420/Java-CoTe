/**
 * 피로도
 */

class Solution {
    //전역변수 선언
    int answer = 0;
    int n; // 배열 길이 저장할 변수
    boolean[] visited; // 방문 여부 확인 배열

    public int solution(int k, int[][] dungeons) {
        n = dungeons.length;
        visited = new boolean[n];
        backtrack(k, 0, dungeons);
        return answer;
    }

    public void backtrack(int k, int cnt, int[][] dungeons) {
        if (cnt > answer) {
            answer = cnt;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                backtrack(k - dungeons[i][1], cnt + 1, dungeons); // 재귀 호출할때마다 cnt +1, k값 빼고 재귀 호출
                visited[i] = false;
            }
        }
    }
}