class Solution {
    // public void inorder(TreeNode root, ArrayList<Integer> arr) {
    //     if(root==null) return;
    //     inorder(root.left,arr);
    //     arr.add(root.val);
    //     inorder(root.right,arr);
    // }
    // public int kthSmallest(TreeNode root, int k) {
    //     ArrayList<Integer> arr = new ArrayList<>();
    //     inorder(root,arr);
    //     return arr.get(k-1);
    // }
    static int ans;
    static int k1;
    public void inorder(TreeNode root) {
        if(root==null) return;
        inorder(root.left);
        k1--;
        if(k1==0) ans = root.val;
        inorder(root.right);
    }
    public int kthSmallest(TreeNode root, int k) {
        k1 = k;
        ans = -1;
        inorder(root);
        return ans;
    }
}