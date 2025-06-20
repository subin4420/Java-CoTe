import java.util.*;

class Solution {
    List<List<Node>> graph;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        //최저 예상 택시요금을 계산해서 return
        //그래프 - 출발, 도착 지점, 가중치. 다익스트라
        graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<fares.length; i++){
            graph.get(fares[i][0]).add(new Node(fares[i][1], fares[i][2]));
            graph.get(fares[i][1]).add(new Node(fares[i][0], fares[i][2]));
        }

        //s, a, b에서 출발하는 모든 지점까지 최단거리
        //s->x + x->a + x->b 의 합이 최소가 되도록
        int[] distS = dijkstra(s, n);
        int[] distA = dijkstra(a, n);
        int[] distB = dijkstra(b, n);

        int sum = Integer.MAX_VALUE;
        for(int i=1; i<=n; i++){
            if(sum > distS[i]+distA[i]+distB[i]){
                sum = distS[i]+distA[i]+distB[i];
            }
        }

        answer = sum;

        return answer;
    }

    public int[] dijkstra(int s, int n){
        int[] dist = new int[n+1];
        for(int i=0; i<=n; i++){
            dist[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[s] = 0;
        pq.add(new Node(s, 0));

        while(!pq.isEmpty()){
            Node u = pq.poll();

            if(dist[u.n] < u.cost) continue;

            for(int i=0; i<graph.get(u.n).size(); i++){
                Node next = graph.get(u.n).get(i);
                if(dist[u.n] + next.cost < dist[next.n]){
                    dist[next.n] = dist[u.n] + next.cost;
                    pq.add(new Node(next.n, dist[next.n]));
                }
            }
        }

        return dist;
    }

    class Node implements Comparable<Node>{
        int n, cost;
        Node(int n, int cost){
            this.n = n;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o){
            //낮은 숫자 순으로 반환되게. 오름차순.
            return this.cost - o.cost;
        }
    }
}