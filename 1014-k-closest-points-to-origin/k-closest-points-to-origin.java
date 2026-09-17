class triplet implements Comparable<triplet>{
    int x;
    int y;
    int dist;
    triplet(int dist,int x,int y) {
        this.dist = dist;
        this.x = x;
        this.y = y;
    }
    public int compareTo(triplet t) {
        return this.dist - t.dist;
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<triplet> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int[] point : points) {
            int x = point[0];
            int y = point[1];
            int dist = x*x + y*y;
            pq.add(new triplet(dist,x,y));
            if(pq.size()>k) pq.remove();
        }
        int[][] ans = new int[k][2];
        for(int i=0;i<k;i++) {
            triplet top = pq.remove();
            ans[i][0] = top.x;
            ans[i][1] = top.y;
        }
        return ans;
    }
}