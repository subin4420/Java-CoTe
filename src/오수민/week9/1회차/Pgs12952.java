package algo4.nqueen;

public class Pgs12952 {
    public int solution(int n) {
        boolean[][] board = new boolean[n][n];

        return placeQueens(board,0,n); //퀸을 놓을 수 있는 개수를 리턴
    }

    int placeQueens(boolean[][] board, int row, int n) {
        //백트랙킹 이용해서 열마다 퀸 하나씩
        if(row == n) return 1; //퀸 n개 고르면 1반환

        int count = 0;
        for(int col=0; col<n; col++) {
            if(checkBoard(board,row,col,n)){ //퀸을 놓을 수 있는 경우에만 탐색 진행
                board[row][col] = true;
                count += placeQueens(board,row+1,n);
                board[row][col] = false;
            }
        }
        return count;
    }

    boolean checkBoard(boolean[][] board, int row, int col, int n) {
        for(int i=0; i<row; i++) {
            if(board[i][col]) return false;
        }
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--,j--) {
            if(board[i][j]) return false;
        }
        for(int i=row-1, j=col+1;i>=0 && j<n;i--,j++){
            if(board[i][j]) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Pgs12952 pgs12952 = new Pgs12952();
        System.out.println(pgs12952.solution(4));
    }
}
