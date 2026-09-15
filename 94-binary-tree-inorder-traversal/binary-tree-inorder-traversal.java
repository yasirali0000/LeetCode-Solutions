class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        // ArrayList<Integer> ans = new ArrayList<>();
        // Stack<TreeNode> st = new Stack<>();
        // TreeNode cur = root;
        // while(st.size()>0 || cur!=null) {
        //     if(cur!=null) {
        //         if(cur.left!=null) {
        //             st.push(cur);
        //             cur = cur.left;
        //         } else {
        //             ans.add(cur.val);
        //             cur = cur.right;
        //         }
        //     } else {
        //         TreeNode top = st.pop();
        //         ans.add(top.val);
        //         cur = top.right;
        //     }
        // }
        ArrayList<Integer> ans = new ArrayList<>();
        TreeNode curr = root;
        while(curr!=null) {
            if(curr.left!=null) {
                TreeNode pred = curr.left;
                while(pred.right!=null && pred.right!=curr) pred = pred.right;
                if(pred.right == null) { // link
                    pred.right = curr;
                    curr = curr.left;
                } else { // unlink
                    pred.right = null;
                    ans.add(curr.val);
                    curr = curr.right;
                }
            } else {
                ans.add(curr.val);
                curr = curr.right;
            }
        }
        return ans;
    }
}