import java.util.*;
class Solution {
    int r, c;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    
    public int solution(String[] maps) {
        int d1, d2 = 0;
        r = maps.length;
        c = maps[0].length();
        
        Node start = null;
        Node exit = null;
        Node lv = null;
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                char tmp = maps[i].charAt(j);
                switch (tmp) {
                    case 'S':
                        start = new Node(i, j, 0);
                        break;
                    case 'L':
                        lv = new Node(i, j, 0); 
                        break;
                    case 'E':
                        exit = new Node(i, j, 0);
                        break;
                }
            }
        }
        d1 = bfs(maps, start, lv);
        d2 = bfs(maps, lv, exit);
        
        
        return d1 > 0 && d2 > 0 ? d1 + d2 : -1;
    }
    
    public int bfs(String[] maps, Node start, Node dest) {
        Deque<Node> deque = new ArrayDeque<>();
        deque.addFirst(start);
        boolean[][] visited = new boolean[r][c];
        while (!deque.isEmpty()) {
            Node now = deque.pollLast();
            if (now.x == dest.x && now.y == dest.y) {
                return now.d;
            }
            for (int i = 0; i < 4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (isRange(nx, ny) && maps[nx].charAt(ny) != 'X' && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    deque.addFirst(new Node(nx, ny, now.d+1));
                }
            }
        }
        return -1;
    }
    
    public boolean isRange(int x, int y) {
        return x >= 0 && x < r && y >= 0 && y < c;
    }
    
    class Node{
        int x;
        int y;
        int d;
        
        public Node(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}