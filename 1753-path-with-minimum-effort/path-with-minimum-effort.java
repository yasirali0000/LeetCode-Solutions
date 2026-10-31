class Solution {
    public class triplet implements Comparable<triplet> {
        int row,col,effort;
        triplet(int row,int col,int effort) {
            this.row = row;
            this.col = col;
            this.effort = effort;
        }
        public int compareTo(triplet t) {
            if(this.effort == t.effort) return this.effort - t.effort;
            return this.effort-t.effort;
        }
    }
    // public int minimumEffortPath(int[][] arr) {
    //     int m = arr.length,n = arr[0].length;
    //     int[][] ans = new int[m][n];
    //     for(int i=0;i<m;i++) {
    //         for(int j=0;j<n;j++) {
    //             ans[i][j] = Integer.MAX_VALUE;
    //         }
    //     }
    //     ans[0][0] = 0;
    //     PriorityQueue<triplet> pq = new PriorityQueue<>();
    //     pq.add(new triplet(0,0,0));
    //     while(pq.size()>0) {
    //         triplet top = pq.remove();
    //         int row = top.row, col = top.col, effort = top.effort;
    //         if(row==m-1 && col ==n-1) break;
    //         if(row>0) {   // going up
    //             int e = Math.abs(arr[row][col] - arr[row-1][col]);
    //             e = Math.max(e,effort);
    //             if(e<ans[row-1][col]) {
    //                 ans[row-1][col] = e;
    //                 pq.add(new triplet(row-1,col,e));
    //             }
    //         }
    //         if(col>0) {   // going left
    //             int e = Math.abs(arr[row][col] - arr[row][col-1]);
    //             e = Math.max(e,effort);
    //             if(e<ans[row][col-1]) {
    //                 ans[row][col-1] = e;
    //                 pq.add(new triplet(row,col-1,e));
    //             }
    //         }
    //         if(row<m-1) {   // going down
    //             int e = Math.abs(arr[row][col] - arr[row+1][col]);
    //             e = Math.max(e,effort);
    //             if(e<ans[row+1][col]) {
    //                 ans[row+1][col] = e;
    //                 pq.add(new triplet(row+1,col,e));
    //             }
    //         }
    //         if(col<n-1) {   // going right
    //             int e = Math.abs(arr[row][col] - arr[row][col+1]);
    //             e = Math.max(e,effort);
    //             if(e<ans[row][col+1]) {
    //                 ans[row][col+1] = e;
    //                 pq.add(new triplet(row,col+1,e));
    //             }
    //         }
    //     }
    //     return ans[m-1][n-1];
    // }


        public int minimumEffortPath(int[][] arr) {
        int m = arr.length,n = arr[0].length;
        int[][] ans = new int[m][n];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                ans[i][j] = Integer.MAX_VALUE;
            }
        }
        ans[0][0] = 0;
        int[] r = {-1,0,1,0};
        int[] c = {0,-1,0,1};
        PriorityQueue<triplet> pq = new PriorityQueue<>();
        pq.add(new triplet(0,0,0));
        while(pq.size()>0) {
            triplet top = pq.remove();
            int row = top.row, col = top.col, effort = top.effort;
            if(row==m-1 && col ==n-1) break;
            for(int i=0;i<4;i++) {
                int newrow = row+r[i];
                int newcol = col+c[i];
                if(newrow<0 || newrow>m-1 || newcol <0 || newcol >n-1) continue;
                int e = Math.abs(arr[row][col] - arr[newrow][newcol]);
                e = Math.max(e,effort);
                if(e<ans[newrow][newcol]) {
                    ans[newrow][newcol] = e;
                    pq.add(new triplet(newrow,newcol,e));
                }
            }
        }
        return ans[m-1][n-1];
    }
}