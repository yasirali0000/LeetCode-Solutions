class Solution {
    public class pair{
        int node;
        int cost;
        pair(int node,int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
    public class triplet{
        int node,cost,stops;
        triplet(int node,int cost,int stops) {
            this.node = node;
            this.cost = cost;
            this.stops = stops;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<pair>());
        for(int i=0;i<flights.length;i++) {
            int from = flights[i][0], to = flights[i][1], cost = flights[i][2];
            adj.get(from).add(new pair(to,cost));
        }
        int[] ans = new int[n];
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[src] = 0;
        Queue<triplet> pq = new LinkedList<>();
        pq.add(new triplet(src,0,0));
        while(pq.size()>0) {
            triplet top = pq.remove();
            int node = top.node,cost = top.cost,stops = top.stops;
            if(stops == k+1) continue;
            for(pair p : adj.get(node)) {
                int totalcost = cost + p.cost;
                if(totalcost < ans[p.node]) {
                    ans[p.node] = totalcost;
                    pq.add(new triplet(p.node,totalcost,stops+1));
                }
            }
        }
        if(ans[dst] == Integer.MAX_VALUE) return -1;
        return ans[dst];
    }
}