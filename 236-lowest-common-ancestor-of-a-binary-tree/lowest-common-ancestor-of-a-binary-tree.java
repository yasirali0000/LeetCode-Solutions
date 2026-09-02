// class Solution {
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         if(root == null) return null;
//         if(root == p || root == q) return root;
//         boolean pinleft = exist(root.left,p);
//         boolean qinleft = exist(root.left,q);
//         if(pinleft && qinleft) return lowestCommonAncestor(root.left,p,q);
//         else if(!pinleft && !qinleft) return lowestCommonAncestor(root.right,p,q);
//         else return root;
//     }
//     public boolean exist(TreeNode root,TreeNode val) {
//         if(root == null) return false;
//         if(root == val) return true;
//         return exist(root.left,val) || exist(root.right,val);
//     }
// }
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p || root == q) return root;
        TreeNode l = lowestCommonAncestor(root.left,p,q);
        TreeNode r = lowestCommonAncestor(root.right,p,q);
        if(l!=null && r!=null) return root;
        if(l==null) return r;
        else return l;
    }
}