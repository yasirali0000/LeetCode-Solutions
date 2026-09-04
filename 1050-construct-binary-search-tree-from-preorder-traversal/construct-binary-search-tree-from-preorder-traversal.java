class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] inorder;
        inorder = Arrays.copyOf(preorder,preorder.length);
        Arrays.sort(inorder);
        int n = inorder.length;
        return build(0,n-1,0,n-1,preorder,inorder);
    }
    public static TreeNode build(int prel, int preh, int inl, int inh,int[] preorder, int[] inorder) {
        if(prel>preh || inl>inh) return null;
        int val = preorder[prel];
        TreeNode root = new TreeNode(val);
        int r=0;
        for(int i=inl;i<=inh;i++) {
            if(inorder[i]==val) {
                r = i;
                break;
            }
        }
        int cnt = r-inl;
        root.left = build(prel+1,prel+cnt,inl,r-1,preorder,inorder);
        root.right = build(prel+cnt+1,preh,r+1,inh,preorder,inorder);
        return root;
    }
}