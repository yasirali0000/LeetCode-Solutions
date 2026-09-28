class Solution {
    // public int Paths(int cr,int cc, int lr, int lc) {
    //     if(cr==lr && cc==lc) {
    //         return 1;
    //     }
    //     if(cr>lr || cc>lc) {
    //         return 0;
    //     }
    //     int right = Paths(cr,cc+1,lr,lc);
    //     int down = Paths(cr+1,cc,lr,lc);
    //     return right + down;
    // }
    // public int uniquePaths(int m, int n) {
    //    return Paths(0,0,m-1,n-1);
    // }


    //  public int uniquePaths(int m, int n) {
    //     if(m==1 || n==1) return 1;
    //     return uniquePaths(m-1,n)+uniquePaths(m,n-1);
    //  }

    // static int[][] dp;
    // public int uniquePaths(int m,int n) {
    //     dp = new int[m+1][n+1];
    //     return paths(m,n);
    // }
    // public int paths(int m,int n) {
    //     if(m==1 || n==1) return 1;
    //     if(dp[m][n] != 0) return dp[m][n];
    //     return dp[m][n] = paths(m-1,n) + paths(m,n-1);
    // }

    public int uniquePaths(int m,int n) {
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(i==0 || j==0) dp[i][j] = 1;
                else dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}