import java.util.Arrays;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int S[] = new int[triangle.length];
        S[0] = triangle[0][0];
        for (int i = 1; i < triangle.length; i++) {
            for (int j = triangle[i].length - 1; j >= 0; j--) {
                if (j == 0) {
                    S[j] += triangle[i][j];
                } else if (j == triangle[i].length - 1) {
                    S[j] = S[j-1] + triangle[i][j];
                } else {
                    S[j] = Math.max(S[j-1] + triangle[i][j], S[j] + triangle[i][j]);
                }
            }
        }
        Arrays.sort(S);
        answer = S[triangle.length - 1];

        return answer;
    }
}