class Solution {
    // public class pair implements Comparable<pair> {
    //     int node;
    //     int time;
    //     pair(int node,int time) {
    //         this.node = node;
    //         this.time = time;
    //     }
    //     public int compareTo(pair p) {
    //         if(this.time == p.time) return Integer.compare(this.node,p.node);
    //         return Integer.compare(this.time,p.time);
    //     }
    // }
    // public int networkDelayTime(int[][] times, int n, int src) {
    //     List<List<pair>> adj = new ArrayList<>();
    //     for(int i=0;i<=n;i++) adj.add(new ArrayList<pair>());
    //     for(int i=0;i<times.length;i++) {
    //         int u = times[i][0], v=times[i][1], time = times[i][2];
    //         adj.get(u).add(new pair(v,time));
    //     }
    //     int[] ans = new int[n+1];
    //     Arrays.fill(ans,Integer.MAX_VALUE);
    //     ans[src] = 0;
    //     PriorityQueue<pair> pq = new PriorityQueue<>();
    //     pq.add(new pair(src,0));
    //     while(pq.size()>0) {
    //         pair top = pq.remove();
    //         int node = top.node,time = top.time;
    //         if(top.time>ans[node]) continue;
    //         for(pair p:adj.get(node)) {
    //             int totaltime = top.time + p.time;
    //             if(totaltime<ans[p.node]) {
    //                 ans[p.node] = totaltime;
    //                 pq.add(new pair(p.node,totaltime));
    //             }
    //         }
    //     }
    //     int max = -1;
    //     for(int i=1;i<=n;i++) {
    //         if(ans[i]==Integer.MAX_VALUE) return -1;
    //         max = Math.max(max,ans[i]);
    //     }
    //     return max;
    // }

    public int networkDelayTime(int[][] times, int n, int src) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        for (int x = 1; x <= n-1; x++) { // n-1 times egdes travel
            for (int i = 0; i < times.length; i++) {
                int u = times[i][0], v = times[i][1], w = times[i][2];
                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v])
                    dist[v] = dist[u] + w;
            }
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                return -1;
            max = Math.max(max, dist[i]);
        }
        return max;
    }
}