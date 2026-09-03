/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // public List<Integer> postorderTraversal(TreeNode root) {
    //     ArrayList<Integer> ans = new ArrayList<>();
    //     if(root==null) return ans;
    //     Stack<TreeNode> st = new Stack<>();
    //     st.push(root);
    //     while(st.size()>0) {
    //         TreeNode top = st.pop();
    //         ans.add(top.val);
    //         if(top.left!=null) st.push(top.left);
    //         if(top.right!=null) st.push(top.right);
    //     }
    //     Collections.reverse(ans);
    //     return ans;
    // }
    List<Integer> list=new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root!=null){
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            list.add(root.val);
        }
        return list;
    }
}