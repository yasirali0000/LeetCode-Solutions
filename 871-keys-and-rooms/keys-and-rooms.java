class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> adj) {
        int n = adj.size();
        boolean[] vis = new boolean[n];
        vis[0] = true;
        bfs(0,adj,vis);
        for(boolean a : vis) {
            if(a==false) return false;
        }
        return true;
    }
    // public void bfs(int start,List<List<Integer>> adj,boolean[] vis) {
    //     Queue<Integer> q = new LinkedList<>();
    //     q.add(start);
    //     while(q.size()>0) {
    //         int front = q.remove();
    //         for(int ele : adj.get(front)) {
    //             if(!vis[ele]) {
    //                 vis[ele] = true;
    //                 q.add(ele);
    //             } 
    //         }
    //     }
    // }

    public void bfs(int start,List<List<Integer>> adj,boolean[] vis) {
        vis[start] = true;
        for(int ele : adj.get(start)) {
            if(!vis[ele]) bfs(ele,adj,vis);
        }
    }
}