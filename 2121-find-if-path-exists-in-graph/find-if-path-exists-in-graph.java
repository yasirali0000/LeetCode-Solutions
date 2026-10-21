class Solution {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        boolean[] vis = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            adj.add(list);
        }

        for (int i=0;i<edges.length;i++) {
            int a= edges[i][0],b = edges[i][1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        vis[start] = true;
        bfs(start,n,adj,vis,end);
        return vis[end];
    }
    public void bfs(int start,int n,List<List<Integer>> adj,boolean[] vis,int end) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        
        while(q.size()>0) {
            int front = q.remove();
            for(int ele : adj.get(front)) {
                if(!vis[ele]) {
                    vis[ele] = true;
                    q.add(ele);
                    if(ele == end) return;
                } 
            }
        }
    }
}