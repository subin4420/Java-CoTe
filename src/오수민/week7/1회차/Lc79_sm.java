package algo3.wordSearch;

public class Solution {
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        boolean[][] visited = new boolean[board.length][board[0].length];
        if(words.length>board.length*board[0].length){return false;}

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == words[0] && permutation(board,visited,words,0,i,j)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean permutation(char[][] board, boolean[][] visited, char[] words,int cnt, int x, int y){
        if(cnt==words.length) return true;
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != words[cnt] || visited[x][y]) {
            return false;
        }
        visited[x][y] = true;

        for(int i=0;i<4;i++){
            if(permutation(board,visited,words,cnt+1,x+dx[i],y+dy[i])) return true;
        }
        visited[x][y] = false;
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        char[][] board = {
//                {'A', 'B', 'C', 'E'},
//                {'S', 'F', 'C', 'S'},
//                {'A', 'D', 'E', 'E'}
//        };
//        String word = "ABCCED";
//        char[][] board = {
//                {'A', 'A'},
//        };
//        String word = "AAA";
        char[][] board = {
                {'C', 'A', 'A'},
                {'A', 'A', 'A'},
                {'B', 'C', 'D'}
        };
        String word = "AAB";

        System.out.println(solution.exist(board,word));

    }
}
