class Solution {
    // public TreeNode insertIntoBST(TreeNode root, int val) {
    //     if(root==null) root = new TreeNode(val);
    //     attach(root,val);
    //     return root;
    // }
    // void attach(TreeNode root, int key) {
    //     if(root.val == key) return;
    //     if(root.val<key) {
    //         if(root.right==null) root.right = new TreeNode(key);
    //         else attach(root.right,key);
    //     } else {
    //         if(root.left==null) root.left = new TreeNode(key);
    //         else attach(root.left,key);
    //     }
    // }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        if(root.val==val) return root;
        else if(root.val<val) root.right = insertIntoBST(root.right,val);
        else root.left = insertIntoBST(root.left,val);
        return root;
    }
}