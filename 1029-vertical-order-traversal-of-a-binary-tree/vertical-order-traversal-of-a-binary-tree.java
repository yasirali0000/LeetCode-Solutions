class Solution {

    class Pair {
        TreeNode node;
        int row;
        int col;

        Pair(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        // column -> nodes
        HashMap<Integer, List<Pair>> map = new HashMap<>();

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root, 0, 0));

        int minCol = Integer.MAX_VALUE;
        int maxCol = Integer.MIN_VALUE;

        while (q.size() > 0) {

            Pair front = q.remove();

            TreeNode node = front.node;
            int row = front.row;
            int col = front.col;

            minCol = Math.min(minCol, col);
            maxCol = Math.max(maxCol, col);

            if (!map.containsKey(col)) {
                map.put(col, new ArrayList<>());
            }

            map.get(col).add(new Pair(node, row, col));

            if (node.left != null) {
                q.add(new Pair(node.left, row + 1, col - 1));
            }

            if (node.right != null) {
                q.add(new Pair(node.right, row + 1, col + 1));
            }
        }

        // Left column -> right column
        for (int col = minCol; col <= maxCol; col++) {

            List<Pair> list = map.get(col);

            // Same column:
            // 1. Smaller row first
            // 2. Same row -> smaller value first
            Collections.sort(list, new Comparator<Pair>() {
                public int compare(Pair a, Pair b) {

                    if (a.row != b.row) {
                        return a.row - b.row;
                    }

                    return a.node.val - b.node.val;
                }
            });

            List<Integer> temp = new ArrayList<>();

            for (Pair p : list) {
                temp.add(p.node.val);
            }

            ans.add(temp);
        }

        return ans;
    }
}