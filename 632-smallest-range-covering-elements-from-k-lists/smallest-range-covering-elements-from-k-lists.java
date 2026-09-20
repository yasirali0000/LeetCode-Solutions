class Solution {
    public class triplet implements Comparable<triplet> {
        int ele;
        int row;
        int col;

        triplet(int ele, int row, int col) {
            this.ele = ele;
            this.row = row;
            this.col = col;
        }

        public int compareTo(triplet t) {
            return this.ele - t.ele;
        }
    }

    public int[] smallestRange(List<List<Integer>> arr) {

        int k = arr.size();

        PriorityQueue<triplet> pq = new PriorityQueue<>();

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        // First element of every list
        for (int i = 0; i < k; i++) {
            int ele = arr.get(i).get(0);

            max = Math.max(max, ele);
            min = Math.min(min, ele);

            pq.add(new triplet(ele, i, 0));
        }

        int a = min;
        int b = max;

        while (true) {

            triplet top = pq.remove();

            int ele = top.ele;
            int row = top.row;
            int col = top.col;

            // Current range = [ele, max]
            if (max - ele < b - a) {
                a = ele;
                b = max;
            }

            // If this list is finished, we cannot cover all lists anymore
            if (col == arr.get(row).size() - 1)
                break;

            int next = arr.get(row).get(col + 1);

            max = Math.max(max, next);

            pq.add(new triplet(next, row, col + 1));
        }

        return new int[]{a, b};
    }
}