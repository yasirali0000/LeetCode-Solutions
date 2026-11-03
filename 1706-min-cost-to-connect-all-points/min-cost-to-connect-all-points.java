class Solution {
    // public class triplet implements Comparable<triplet> {
    //     int node;
    //     int parent;
    //     int dist;
    //     triplet(int node,int parent,int dist) {
    //         this.node = node;
    //         this.parent = parent;
    //         this.dist = dist;
    //     }
    //     public int compareTo(triplet p) {
    //         if(this.dist == p.dist) return Integer.compare(this.node,p.node);
    //         return Integer.compare(this.dist,p.dist);
    //     }
    // }
    // public int minCostConnectPoints(int[][] points) {
    //     int n = points.length;
    //     PriorityQueue<triplet> pq = new PriorityQueue<>();
    //     pq.add(new triplet(0,-1,0));
    //     int sum = 0;
    //     boolean[] vis = new boolean[n];
    //     while(pq.size()>0) {
    //         triplet top = pq.remove();
    //         int node = top.node,parent = top.parent,dist = top.dist;
    //         if(vis[node]==true) continue;
    //         sum += dist;
    //         vis[node] = true;
    //         for(int i=0;i<n;i++) {
    //             if(i==node || i==parent) continue;
    //             if( vis[i]==true) continue;
                // int x1 = points[node][0],y1 = points[node][1];
                // int x2 = points[i][0],y2 = points[i][1];
                // int mindist = Math.abs(x2-x1) + Math.abs(y2-y1);
    //             pq.add(new triplet(i,node,mindist));
    //         }
    //     }
    //     return sum;
    // }
    static int[] parent, size;
    int leader(int u) {
        if(parent[u]==u) return u;
        return parent[u] = leader(parent[u]);
    }
    void union(int u,int v) {
        int a = leader(u);
        int b = leader(v);
        if(a!=b) {
            if(size[a]>size[b]) {
                parent[b] = a;
                size[a] += size[b];
            } else {
                parent[a] = b;
                size[b] += size[a];
            }
        }
    }
    public class triplet implements Comparable<triplet> {
        int u;
        int v;
        int dist;
        triplet(int u,int v,int dist) {
            this.u = u;
            this.v = v;
            this.dist = dist;
        }
        public int compareTo(triplet p) {
            if(this.dist == p.dist) return Integer.compare(this.u,p.u);
            return Integer.compare(this.dist,p.dist);
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        parent = new int[n+1];
        size = new int[n+1];
        for(int i=0;i<n;i++) {
            parent[i]=i;
            size[i]=1;
        }
        ArrayList<triplet> list = new ArrayList<>();
        for(int u=0;u<n;u++) {
            for(int v=u+1;v<n;v++) {
                // u to v edge
                int x1 = points[u][0],y1 = points[u][1];
                int x2 = points[v][0],y2 = points[v][1];
                int mindist = Math.abs(x2-x1) + Math.abs(y2-y1);
                list.add(new triplet(u,v,mindist));
            }
        }
        Collections.sort(list);
        int cost = 0;
        for(int i=0;i<list.size();i++) {
            triplet top = list.get(i);
            int u = top.u,v = top.v,dist = top.dist;
            if(leader(u)!=leader(v)) {
                cost += dist;
                union(u,v);
            }
        }
        return cost;
    }
}