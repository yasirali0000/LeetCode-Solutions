class Solution {
    // public int findCircleNum(int[][] adj) {
    //     int n = adj.length;
    //     int count = 0;
    //     boolean[] vis = new boolean[n];
    //     for(int i=0;i<n;i++) {
    //         if(!vis[i]) {
    //             bfs(i,vis,adj);
    //             count++;
    //         }
    //     }
    //     return count;
    // }
    // public void bfs(int i,boolean[] vis,int[][] adj) {
    //     int n = adj.length;
    //     vis[i] = true;
    //     Queue<Integer> q = new LinkedList<>();
    //     q.add(i);
    //     while(q.size()>0) {
    //         int front = q.remove();
    //         for(int j=0;j<n;j++) {
    //             if(adj[front][j] == 1 && !vis[j]) {
    //                 q.add(j);
    //                 vis[j] = true;
    //             }
    //         }
    //     }
    // }

    // public int findCircleNum(int[][] adj) {
    //     int n = adj.length;
    //     int count = 0;
    //     boolean[] vis = new boolean[n];
    //     for (int i = 0; i < n; i++) {
    //         if (!vis[i]) {
    //             dfs(i, vis, adj);
    //             count++;
    //         }
    //     }
    //     return count;
    // }

    // public void dfs(int i, boolean[] vis, int[][] adj) {
    //     int n = adj.length;
    //     vis[i] = true;
    //     for (int j = 0; j < n; j++) {
    //         if (adj[i][j] == 1 && !vis[j]) {
    //             dfs(j,vis,adj);
    //         }
    //     }
    // }
       

    // Disjoint Set Union
    // static int[] parent;
    // public int find(int a) {
    //     if(parent[a]==a) return a;
    //     return find(parent[a]);
    // }
    // public void union(int a,int b) {
    //     int leadera = find(a);
    //     int leaderb = find(b);
    //     if(leadera!=leaderb) {
    //         parent[leaderb] = leadera;
    //     }
    // }
    // public int findCircleNum(int[][] adj) {
    //     int n = adj.length;
    //     parent  = new int[n+1];
    //     for(int i=1;i<=n;i++) {
    //         parent[i] = i;
    //     }
    //     for(int i=0;i<n;i++) {
    //         for(int j=0;j<n;j++) {
    //             // edge is from i+1 to j+1
    //             if(i!=j && adj[i][j]==1) union(i+1,j+1);
    //         }
    //     }
    //     int count = 0;
    //     for(int i=1;i<=n;i++) {
    //         if(parent[i]==i) count++;
    //     }
    //     return count;
    // }

    // optimized DSU
    static int[] parent;
    static int[] size;
    public int find(int a) {
        if(parent[a]==a) return a;
        return parent[a]= find(parent[a]);
    }
    public void union(int a,int b) {
        a = find(a);
        b = find(b);
        if(a!=b) {
            if(size[a]>size[b]) {
                parent[a] = b;
                size[a] += size[b];
            } else {
                parent[b] = a;
                size[b] += size[a];
            }
        }
    }
    public int findCircleNum(int[][] adj) {
        int n = adj.length;
        parent  = new int[n+1];
        size  = new int[n+1];
        for(int i=1;i<=n;i++) {
            parent[i] = i;
            size[i] = 1;
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                // edge is from i+1 to j+1
                if(i!=j && adj[i][j]==1) union(i+1,j+1);
            }
        }
        int count = 0;
        for(int i=1;i<=n;i++) {
            if(parent[i]==i) count++;
        }
        return count;
    }
}