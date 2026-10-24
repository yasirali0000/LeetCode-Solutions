class Solution {
    static boolean ans;

    public boolean isBipartite(int[][] adj) {
        ans = true;
        int n = adj.length;
        int[] vis = new int[n];
        Arrays.fill(vis, -1);
        for (int i = 0; i < n; i++) {
            if (ans == false)
                return ans;
            if (vis[i] == -1)
                vis[i]=0;
                dfs(i, adj, vis); // bfs(i,adj,vis);
        }
        return ans;
    }

    public void dfs(int i, int[][] adj, int[] vis) {
        int color = vis[i];
        for (int ele : adj[i]) {
            if (vis[ele] == vis[i]) {
                ans = false;
                return;
            }
            if (vis[ele] == -1) {
                vis[ele] = 1 - color;
                dfs(ele, adj, vis);
                if (ans == false) {
                    return;
                }
            }
        }
    }

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