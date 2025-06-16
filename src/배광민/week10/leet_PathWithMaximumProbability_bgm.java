import java.util.*;

public class leet_PathWithMaximumProbability_bgm {
    class Solution {
        class Pair implements Comparable<Pair> {
            int node;
            double cost;

            public Pair(int node, double cost){
                this.node = node;
                this.cost = cost;
            }

            @Override
            public int compareTo(Pair o){
                return Double.compare(this.cost, o.cost);
            }
        }

        double dijkstra(Map<Integer, List<Pair>> graph, int start, int end, int n){
            double[] distance = new double[n];
            Queue<Pair> que = new PriorityQueue(Collections.reverseOrder());
            que.add(new Pair(start, 1));
            distance[start] = 1;
            while(!que.isEmpty()){
                Pair pair = que.remove();
                if(distance[pair.node] > pair.cost) continue;

                for(Pair next : graph.get(pair.node)){
                    double nextCost = pair.cost * next.cost;
                    if(distance[next.node] < nextCost){
                        que.add(new Pair(next.node, nextCost));
                        distance[next.node] = nextCost;
                    }
                }
            }
            return distance[end];
        }
        public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
            Map<Integer, List<Pair>> graph = new HashMap();

            for(int i = 0; i<n; i++){
                graph.put(i, new ArrayList());
            }

            for(int i = 0; i<edges.length; i++){
                graph.get(edges[i][0]).add(new Pair(edges[i][1], succProb[i]));
                graph.get(edges[i][1]).add(new Pair(edges[i][0], succProb[i]));
            }
            double answer = dijkstra(graph, start_node, end_node, n);
            return answer;
        }
    }
}
