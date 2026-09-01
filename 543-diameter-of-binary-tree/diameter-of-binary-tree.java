class Solution {
    int max;
    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        levels(root);
        return max;
    }
    public int levels(TreeNode root) {
        if(root==null) return 0;
        int level1 = levels(root.left);
        int level2 = levels(root.right);
        max = Math.max(max,level1+level2);
        return 1+(Math.max(level1,level2));
    }
}