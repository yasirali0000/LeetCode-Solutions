class Solution {
    // static boolean ans;
    // public boolean isBipartite(int[][] adj) {
    //     ans = true;
    //     int n = adj.length;
    //     int[] vis = new int[n];
    //     Arrays.fill(vis, -1);
    //     for (int i = 0; i < n; i++) {
    //         if (ans == false)
    //             return ans;
    //         if (vis[i] == -1)
    //             vis[i]=0;
    //             dfs(i, adj, vis); // bfs(i,adj,vis);
    //     }
    //     return ans;
    // }

    // public void dfs(int i, int[][] adj, int[] vis) {
    //     int color = vis[i];
    //     for (int ele : adj[i]) {
    //         if (vis[ele] == vis[i]) {
    //             ans = false;
    //             return;
    //         }
    //         if (vis[ele] == -1) {
    //             vis[ele] = 1 - color;
    //             dfs(ele, adj, vis);
    //             if (ans == false) {
    //                 return;
    //             }
    //         }
    //     }
    // }

    // public void bfs(int i,int[][] adj,int[] vis) {
    //     Queue<Integer> q = new LinkedList<>();
    //     vis[i] = 0;
    //     q.add(i);
    //     while(q.size()>0) {
    //         int front = q.remove();
    //         int color = vis[front];
    // for(int ele : adj[front]) {
    //     if(vis[ele]==vis[front]) {
    //         ans = false;
    //         return;
    //     }
    //             if(vis[ele]==-1) {
    //                 vis[ele] = 1-color;
    //                 q.add(ele);
    //             }
    //         }
    //     }
    // }

    static int[] parent, size;
    static boolean[] parity;
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
                parity[v] = !parity[u]; // smaller wale ki parity change kro
            } else {
                parent[a] = b;
                size[b] += size[a];
                parity[u] = !parity[v];  // larger wale ki parity change kro
            }
        }
    }
    public boolean isBipartite(int[][] adj) {
        int n = adj.length;
        parent = new int[n];
        size = new int[n];
        parity = new boolean[n];
        for(int i=0;i<n;i++) {
            parent[i] = i;
            size[i] = 1;
            parity[i] = false;
        }
        for(int i =0;i<adj.length;i++) {
            for(int j=0;j<adj[i].length;j++) {
                int u = i,v = adj[i][j];
                if(v>u) {
                    if(leader(u)==leader(v)) {
                        if(parity[u]==parity[v]) return false;
                    } else {
                        union(u,v);
                    }
                }
            }
        }
        return true;
    }
}

// class Solution {
//     public boolean isBipartite(int[][] adj) {
//         int n = adj.length;
//         int[] vis = new int[n];
//         Arrays.fill(vis,-1);
//         for(int i=0;i<n;i++) {
//             if(vis[i]==-1) {
//                 if(!bfs(i,adj,vis)) return false;
//             }
//         }
//         return true;
//     }
//     public boolean bfs(int i,int[][] adj,int[] vis) {
//         Queue<Integer> q = new LinkedList<>();
//         vis[i] = 0;
//         q.add(i);
//         while(q.size()>0) {
//             int front = q.remove();
//             int color = vis[front];
//             for(int ele : adj[front]) {
//                 if(vis[ele]==vis[front]) {
//                     return false;
//                 }
//                 if(vis[ele]==-1) {
//                     vis[ele] = 1-color;
//                     q.add(ele);
//                 }
//             }
//         }
//         return true;
//     }
// }