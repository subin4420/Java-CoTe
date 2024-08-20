package algo8.합승택시요금;

import java.util.*;

class Edge implements Comparable<Edge>{
    int node, cost;
    public Edge(int node, int cost){
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge other){
        //최소시간 구하는거니까 this 먼저
        return Integer.compare(this.cost, other.cost);
    }
}

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        Map<Integer,List<Edge>> graph = new HashMap<>();
        for(int i=1;i<=n;i++){
            graph.put(i,new ArrayList<>());
        }
        for(int[] fare:fares){
            int n1 = fare[0];
            int n2 = fare[1];
            int w = fare[2];
            //무방향이라 2개 다 넣어주기
            graph.get(n1).add(new Edge(n2,w));
            graph.get(n2).add(new Edge(n1,w));
        }

        //s,a,b를 각각 start로 구하기
        int[] sDist = dijkstra(graph, s, n);
        int[] aDist = dijkstra(graph, a, n);
        int[] bDist = dijkstra(graph, b, n);

        int minC = Integer.MAX_VALUE;

        //모든 노드를 순회해서 최소 비용 찾기
        for(int i=1;i<=n;i++){
            int cost = sDist[i]+aDist[i]+bDist[i];
            minC = Math.min(minC, cost);
        }

        return minC;
    }

    int[] dijkstra(Map<Integer,List<Edge>> graph, int s, int n){
        int INF = Integer.MAX_VALUE;
        int[] costs = new int[n+1];
        Arrays.fill(costs,INF);

        Queue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(s,0));
        costs[s] = 0;

        while(!pq.isEmpty()){
            Edge cur = pq.remove();
            if(costs[cur.node]<cur.cost) continue;

            for(Edge next: graph.get(cur.node)){
                int nextC = costs[cur.node]+next.cost;
                if(nextC < costs[next.node]){
                    pq.add(new Edge(next.node, nextC));
                    costs[next.node] = nextC;
                }
            }
        }

        return costs;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(6,4,5,6,new int[][] {
                {2, 6, 6},
                {6, 3, 7},
                {4, 6, 7},
                {6, 5, 11},
                {2, 5, 12},
                {5, 3, 20},
                {2, 4, 8},
                {4, 3, 9}
        });
    }
}