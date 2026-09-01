/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p || root == q) return root;
        boolean pinleft = exist(root.left,p);
        boolean qinleft = exist(root.left,q);
        if(pinleft && qinleft) return lowestCommonAncestor(root.left,p,q);
        else if(!pinleft && !qinleft) return lowestCommonAncestor(root.right,p,q);
        else return root;
    }
    public boolean exist(TreeNode root,TreeNode val) {
        if(root == null) return false;
        if(root == val) return true;
        return exist(root.left,val) || exist(root.right,val);
    }
}