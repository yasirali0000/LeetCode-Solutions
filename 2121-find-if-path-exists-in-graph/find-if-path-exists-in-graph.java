class Solution {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        boolean[] vis = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            adj.add(list);
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        vis[start] = true;
        bfs(start,n,adj,vis);
        return vis[end];
    }
    public void bfs(int start,int n,List<List<Integer>> adj,boolean[] vis) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        
        while(q.size()>0) {
            int front = q.remove();
            for(int ele : adj.get(front)) {
                if(!vis[ele]) {
                    vis[ele] = true;
                    q.add(ele);
                } 
            }
        }
    }
}