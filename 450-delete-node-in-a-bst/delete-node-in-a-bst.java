class Solution {
    public TreeNode deleteNode(TreeNode root, int tar) {
        if(root == null) return null;
        if(root.val>tar) root.left = deleteNode(root.left,tar);
        else if(root.val<tar) root.right = deleteNode(root.right,tar);
        else {
            if(root.left == null && root.right==null) return null;
            if(root.left ==null) return root.right;
            if(root.right == null) return root.left;
            TreeNode succ = root.right;
            while(succ.left!=null) succ = succ.left;
            root.right = deleteNode(root.right,succ.val);
            succ.left = root.left;
            succ.right = root.right;
            return succ;
        }
        return root;
    }
}