import java.util.*;
class Solution {
    static final int INF = Integer.MAX_VALUE / 2;
   public int solution(int N, int[][] road, int K) {

        int answer = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
        int[] dist = new int[N+1];

        Arrays.fill(dist,INF);

        for(int idx = 0; idx<=N;idx++){
            adj.add(new ArrayList<>());
        }

        for(int idx = 0; idx<road.length;idx++)
        {
            int s = road[idx][0];
            int e = road[idx][1];
            int w = road[idx][2];

            adj.get(s).add(new Edge(e,w));
            adj.get(e).add(new Edge(s,w));
        }

        dist[1] = 0;
        pq.offer(new Edge(1,0));

        while(!pq.isEmpty()){
            Edge e = pq.poll();
            for(Edge edge : adj.get(e.to)){
                if(dist[edge.to] > dist[e.to]+edge.weight){
                    dist[edge.to] = dist[e.to]+edge.weight;
                    pq.offer(edge);
                }
            }
        }

        for(int weight : dist){
            if(weight <=K){
                answer++;
            }
        }
        return answer;
    }

    class Edge implements Comparable<Edge>{
        int to, weight;

        Edge(int to , int weight){
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge e){
            return this.weight - e.weight;
        }
    }
}
