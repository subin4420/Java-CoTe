class Edge implements Comparable<Edge>{
    int node;
    double cost;
    public Edge(int node, double cost){
        this.node = node;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge other){
        return Double.compare(other.cost, this.cost);
    }
}
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer,List<Edge>> graph = new HashMap<>();
        for(int i=0;i<=n;i++){
            graph.put(i,new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            double w = succProb[i];
            graph.get(u).add(new Edge(v,w));
            graph.get(v).add(new Edge(u,w));
        }

        int INF = Integer.MIN_VALUE;
        double[] costs = new double[n];
        Arrays.fill(costs,INF);

        Queue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start_node,1));
        costs[start_node] = 1;

        while(!pq.isEmpty()){
            Edge cur = pq.remove();
            if(costs[cur.node]<cur.cost) continue;
            for(Edge next:graph.get(cur.node)){
                double nextCost = costs[cur.node]*next.cost;
                if(nextCost>costs[next.node]){
                    pq.add(new Edge(next.node, nextCost));
                    costs[next.node] = nextCost;
                }
            }
        }

        if(costs[end_node]==INF) return 0;
        return costs[end_node];
    }
}