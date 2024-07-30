
public class pgs12952_bgm {

    public class Solution {
        boolean[] columnCheck;
        boolean[] leftDiagnalCheck;
        boolean[] rightDiagnalCheck;

        public int solution(int n) {
            columnCheck = new boolean[n];
            leftDiagnalCheck = new boolean[2 * n - 1];
            rightDiagnalCheck = new boolean[2 * n - 1];

            return placeQueens(0, n); //✅ 퀸을 놓을 수 있는 개수를 리턴한다.
        }

        int placeQueens(int row, int n) { //✅ 백트래킹을 활용하여 열마다 퀸을 하나씩 놓는다.
            if (n == row) return 1;  //✅ 퀸을 n개 골랐다면 1을 반환한다.

            int sum = 0;
            for (int col = 0; col < n; col++) {

                if (checkBoard(row, col, n)) { //✅ 퀸을 놓을 수 있는 경우에만 탐색을 진행한다.
                    columnCheck[col] = true;
                    leftDiagnalCheck[row - col + n - 1] = true;
                    rightDiagnalCheck[row + col] = true;

                    sum += placeQueens(row + 1, n);

                    columnCheck[col] = false;
                    leftDiagnalCheck[row - col + n - 1] = false;
                    rightDiagnalCheck[row + col] = false;
                }
            }

            return sum;
        }

        boolean checkBoard(int row, int col, int n) {
            return (!columnCheck[col] &&
                    !leftDiagnalCheck[row - col + n - 1] &&
                    !rightDiagnalCheck[row + col]);
        }
    }
}
