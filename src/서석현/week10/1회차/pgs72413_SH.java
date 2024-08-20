//합승 택시 요금
package Programmers;

import java.util.*;

public class pgs72413_SH {
    static class Solution {
        // Edge 클래스는 노드 간의 경로와 비용을 나타냅니다.
        class Edge implements Comparable<Edge> {
            int node, cost;

            public Edge(int node, int cost) {
                this.node = node;
                this.cost = cost;
            }

            // 우선순위 큐에서 비용을 기준으로 정렬하기 위해 compareTo 메서드를 구현합니다.
            @Override
            public int compareTo(Edge next) {
                return Integer.compare(this.cost, next.cost);
            }
        }

        // 다익스트라 알고리즘을 구현하여 최단 거리를 계산합니다.
        int[] dijkstra(Map<Integer, List<Edge>> graph, int start) {
            int n = graph.size(); // 노드의 개수
            int[] distance = new int[n + 1]; // 시작 노드로부터 각 노드까지의 최단 거리를 저장할 배열
            Arrays.fill(distance, Integer.MAX_VALUE); // 초기 거리를 무한대로 설정합니다.

            // 우선순위 큐를 사용하여 비용이 적은 경로부터 탐색합니다.
            Queue<Edge> que = new PriorityQueue<>();
            que.add(new Edge(start, 0)); // 시작 노드를 큐에 넣습니다.
            distance[start] = 0; // 시작 노드의 거리는 0으로 설정합니다.

            while (!que.isEmpty()) {
                Edge edge = que.remove(); // 현재 노드를 큐에서 꺼냅니다.
                // 이미 계산된 거리보다 큰 경우, 무시합니다.
                if (distance[edge.node] < edge.cost) continue;

                // 현재 노드에 연결된 다른 노드들을 탐색합니다.
                for (Edge next : graph.get(edge.node)) {
                    int nextCost = distance[edge.node] + next.cost; // 새로운 비용을 계산합니다.
                    // 더 짧은 경로가 발견되면 거리 배열을 업데이트하고 큐에 추가합니다.
                    if (distance[next.node] > nextCost) {
                        distance[next.node] = nextCost;
                        que.add(new Edge(next.node, nextCost));
                    }
                }
            }
            return distance; // 각 노드로의 최단 거리를 반환합니다.
        }

        public int solution(int n, int s, int a, int b, int[][] fares) {
            int answer = Integer.MAX_VALUE; // 최소 비용을 찾기 위한 변수
            Map<Integer, List<Edge>> graph = new HashMap<>(); // 그래프를 표현할 맵

            // 그래프를 초기화합니다.
            for (int i = 1; i <= n; i++) {
                graph.put(i, new ArrayList<>());
            }
            // 주어진 요금을 통해 그래프를 구성합니다.
            for (int[] next : fares) {
                graph.get(next[0]).add(new Edge(next[1], next[2])); // 노드 u에서 노드 v로의 간선과 비용 추가
                graph.get(next[1]).add(new Edge(next[0], next[2])); // 노드 v에서 노드 u로의 간선과 비용 추가
            }

            // 각 출발지점에서 다른 모든 지점으로의 최단 거리를 구합니다.
            int[] answerS = dijkstra(graph, s); // 출발 지점 s에서의 최단 거리
            int[] answerA = dijkstra(graph, a); // A의 도착 지점 a에서의 최단 거리
            int[] answerB = dijkstra(graph, b); // B의 도착 지점 b에서의 최단 거리

            // 모든 경유지 노드 i에 대해, s -> i -> a + s -> i -> b 경로의 비용을 계산하여 최소 비용을 찾습니다.
            for (int i = 1; i <= n; i++) {
                int tmp = answerS[i] + answerA[i] + answerB[i]; // s -> i + i -> a + i -> b 의 총 비용
                answer = Math.min(answer, tmp); // 최소 비용을 갱신합니다.
            }

            return answer; // 최소 택시 요금을 반환합니다.
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = 6;
        int s = 4;
        int a = 6;
        int b = 2;
        int[][] fares = {
                {4, 1, 10},
                {3, 5, 24},
                {5, 6, 2},
                {3, 1, 41},
                {5, 1, 24},
                {4, 6, 50},
                {2, 4, 66},
                {2, 3, 22},
                {1, 6, 25}
        };

        int result = solution.solution(n, s, a, b, fares);
        System.out.println(result);
    }
}
