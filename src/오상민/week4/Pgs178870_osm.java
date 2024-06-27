class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int point1 = 0;
        int point2 = 0;
        int count = sequence.length;
        int sum = sequence[0];
        while (point1 <= sequence.length - 1) {
            if (sum == k) {
                if (point2 - point1 < count) {
                    answer[0] = point1;
                    answer[1] = point2;
                    count = point2 - point1;
                }
                if (point2 == sequence.length - 1) {
                    sum -= sequence[point1];
                    point1++;
                } else {
                    point2++;
                    sum += sequence[point2];
                }
            } else if (sum < k) {
                if (point2 == sequence.length - 1) {
                    sum -= sequence[point1];
                    point1++;
                } else {
                    point2++;
                    sum += sequence[point2];
                }
            } else {
                sum -= sequence[point1];
                point1++;
            }
        }
        return answer;
    }
}
