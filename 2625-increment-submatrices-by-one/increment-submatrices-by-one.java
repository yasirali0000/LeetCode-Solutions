class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] diff = new int[n+1][n+1];
        for (int[] query : queries) {
            int r1 = query[0];
            int c1 = query[1];
            int r2 = query[2];
            int c2 = query[3];
            diff[r1][c1] += 1;
            diff[r1][c2 + 1] -= 1;
            diff[r2 + 1][c1] -= 1;
            diff[r2 + 1][c2 + 1] += 1;
        }
        int[][] ans = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                ans[i][j] = diff[i][j];
                if(i > 0) {
                    ans[i][j] += ans[i - 1][j];
                }
                if(j > 0) {
                    ans[i][j] += ans[i][j - 1];
                }
                if(i > 0 && j > 0) {
                    ans[i][j] -= ans[i - 1][j - 1];
                }
            }
        }
        return ans;
    }
}