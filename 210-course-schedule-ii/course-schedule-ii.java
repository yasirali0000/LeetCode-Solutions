class Solution {
    public int[] findOrder(int n, int[][] pre) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=1;i<=n;i++) adj.add(new ArrayList<>());
        int[] indegree = new int[n];
        for(int[] pres : pre) {
            // int a = pre[i][0], b = pre[i][1];  // b-> edge
            adj.get(pres[1]).add(pres[0]);
            indegree[pres[0]]++;
        }
        // kahn's algorithm
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++) {
            if(indegree[i]==0) q.add(i);
        }
        while(q.size()>0) {
            int front = q.remove();
            ans.add(front);
            for(int ele : adj.get(front)) {
                indegree[ele]--;
                if(indegree[ele]==0) q.add(ele);
            }
        }
        int[] ans2 = new int[ans.size()];
        for(int i=0;i<ans.size();i++) {
            ans2[i]= ans.get(i);
        }
        if(ans.size()!=n) return new int[0];
        else return ans2;
    }
}