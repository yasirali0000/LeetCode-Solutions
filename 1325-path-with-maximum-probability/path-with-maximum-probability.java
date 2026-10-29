class Solution {
    public class pair implements Comparable<pair> {
        int node;
        double prob;
        pair(int node,double prob) {
            this.node = node;
            this.prob = prob;
        }
        public int compareTo(pair p) {
            if(this.prob == p.prob) return Integer.compare(this.node,p.node);
            return Double.compare(this.prob,p.prob);
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<pair>());
        for(int i=0;i<edges.length;i++) {
            int u = edges[i][0], v=edges[i][1];
            double prob = succProb[i];
            adj.get(u).add(new pair(v,prob));
            adj.get(v).add(new pair(u,prob));
        }
        double[] ans = new double[n];
        ans[start] = 1;
        PriorityQueue<pair> pq = new PriorityQueue<>(Collections.reverseOrder());   // maxheap
        pq.add(new pair(start,1));
        while(pq.size()>0) {
            pair top = pq.remove();
            int node = top.node;
            double prob = top.prob;
            if(top.prob>ans[node]) continue;
            for(pair p:adj.get(node)) {
                double totalprob = p.prob*prob;
                if(totalprob > ans[p.node]) {
                    ans[p.node] = totalprob;
                    pq.add(new pair(p.node,totalprob));
                }
            }
        }
        return ans[end];
    }
}