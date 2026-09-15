class quad{
    int max;
    int min;
    int sum;
    boolean isbst;
    quad(int max,int min, int sum, boolean isbst) {
        this.max = max;
        this.min = min;
        this.sum = sum;
        this.isbst = isbst;
    }
}
class Solution {
    static int maxsum;
    public int maxSumBST(TreeNode root) {
        maxsum = 0;
        helper(root);
        return maxsum;
    }
    static quad helper(TreeNode root) {
        if(root==null) return new quad(Integer.MIN_VALUE,Integer.MAX_VALUE,0,true);
        quad lst = helper(root.left);
        quad rst = helper(root.right);
        int max = Math.max(root.val,Math.max(lst.max,rst.max));
        int min = Math.min(root.val,Math.min(lst.min,rst.min));
        int sum = root.val + lst.sum + rst.sum;
        boolean isbst = lst.isbst && rst.isbst && (lst.max<root.val) && (rst.min>root.val);
        if(isbst) maxsum = Math.max(sum,maxsum);
        return new quad(max,min,sum,isbst);
    }
}