package ct_0819;
import java.util.*;

public class leet_Path_with_MAX_Prob_sb {
    class Solution {
        class Edge implements Comparable<Edge>{
            int node;
            double cost;
            public Edge(int node, double cost){
                this.node = node;
                this.cost = cost;
            }
            @Override
            public int compareTo(Edge other){
                return Double.compare(other.cost,this.cost);
            }
        }
        public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
            Map<Integer, List<Edge>> graph = new HashMap<>();
            for(int i=0;i<n;i++){
                graph.put(i, new ArrayList<>());
            }
            for(int i=0;i<edges.length;i++){
                graph.get(edges[i][0]).add(new Edge(edges[i][1],succProb[i]));
                graph.get(edges[i][1]).add(new Edge(edges[i][0],succProb[i]));
            }
            double d =  dijkstra(graph, start_node, end_node, n);
            return d;
        }

        double dijkstra(Map<Integer, List<Edge>> graph, int start, int end, int n){
            double[] dist = new double[n];
            Arrays.fill(dist, 0.0);
            //큐만들기

            Queue<Edge> pq = new PriorityQueue<>();
            pq.add(new Edge(start, 1.0));
            dist[start]=1.0;

            while(!pq.isEmpty()){
                Edge cur = pq.remove();

                if(dist[cur.node] > cur.cost) continue;

                for(Edge e : graph.get(cur.node)){
                    double nextCost = dist[cur.node] * e.cost;
                    if (nextCost > dist[e.node]){
                        pq.add(new Edge(e.node, nextCost));
                        dist[e.node] = nextCost;
                    }
                }
            }
            return dist[end];
        }
    }
}
