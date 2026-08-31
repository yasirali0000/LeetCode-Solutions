class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        int leftlevel = levels(root.left);
        int rightlevel = levels(root.right);
        if(Math.abs(leftlevel-rightlevel)>1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
    public int levels(TreeNode root) {
        if(root == null) return 0;
        return (1+ Math.max(levels(root.left),levels(root.right)));
    }
}