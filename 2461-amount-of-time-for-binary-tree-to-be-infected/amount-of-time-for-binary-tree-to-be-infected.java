class pair {
    TreeNode node;
    int dist;
    pair(TreeNode node,int dist) {
        this.node = node;
        this.dist = dist;
    }
}
class Solution {
    static TreeNode start;
    static HashMap<TreeNode,TreeNode> parent;
    public int amountOfTime(TreeNode root, int tar) {
        start = null;
        parent = new HashMap<>();
        dfs(root,tar);
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(start,0));
        HashSet<TreeNode> burned = new HashSet<>();
        burned.add(start);
        int time = 0;
        while(q.size()>0) {
            pair front = q.remove();
            int dist = front.dist;
            TreeNode node = front.node;
            time = Math.max(time,dist);
            if(node.left!=null && !burned.contains(node.left)) {
                q.add(new pair(node.left,dist+1));
                burned.add(node.left);
            }
            if(node.right!=null && !burned.contains(node.right)) {
                q.add(new pair(node.right,dist+1));
                burned.add(node.right);
            }
            if(parent.containsKey(node) && !burned.contains(parent.get(node))) {
                q.add(new pair(parent.get(node),dist+1));
                burned.add(parent.get(node));
            }
        }
        return time;
    }
    public static void dfs(TreeNode root,int target) {
        if(root==null) return;
        if(root.val==target) start = root;
        if(root.left!=null) parent.put(root.left,root);
        if(root.right!=null) parent.put(root.right,root);
        dfs(root.left,target);
        dfs(root.right,target);
    }
}