// class Pair {
//     long max;
//     long min;

//     Pair(long max, long min) {
//         this.max = max;
//         this.min = min;
//     }
// }

// class Solution {
//     static boolean flag;

//     public boolean isValidBST(TreeNode root) {
//         flag = true;
//         maxmin(root);
//         return flag;
//     }

//     Pair maxmin(TreeNode root) {
//         if (root == null)
//             return new Pair(Long.MIN_VALUE, Long.MAX_VALUE);
//         Pair lst = maxmin(root.left);
//         Pair rst = maxmin(root.right);
//         long max = Math.max(root.val, Math.max(lst.max, rst.max));
//         long min = Math.min(root.val, Math.min(lst.min, rst.min));
//         if (lst.max >= root.val || rst.min <= root.val)
//             flag = false;
//         return new Pair(max, min);
//     }
// }

class Solution {
    public boolean isValidBST(TreeNode root) {
        TreeNode curr = root;
        long prev = Long.MIN_VALUE;;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode pred = curr.left;
                while (pred.right != null && pred.right != curr)
                    pred = pred.right;
                if (pred.right == null) { // link
                    pred.right = curr;
                    curr = curr.left;
                } else { // unlink
                    pred.right = null;
                    if(curr.val <= prev) return false;
                    prev = curr.val;
                    curr = curr.right;
                }
            } else {
                if(curr.val <= prev) return false;
                prev = curr.val;
                curr = curr.right;
            }
        }
        return true;
    }
}