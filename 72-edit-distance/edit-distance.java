class Solution {
    public int minDistance(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                dp[i][j] = -1;
            }
        }
        return help(m-1,n-1,new StringBuilder(s1), new StringBuilder(s2),dp);
    }
    public int help(int i,int j,StringBuilder s1, StringBuilder s2,int[][] dp) {
        if(i<0) return j+1;
        if(j<0) return i+1;
        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)) return dp[i][j] = help(i-1,j-1,s1,s2,dp);
        int replace = 1 + help(i-1,j-1,s1,s2,dp);
        int remove = 1 + help(i-1,j,s1,s2,dp);
        int insert = 1 + help(i,j-1,s1,s2,dp);
        return dp[i][j] = Math.min(replace,Math.min(insert,remove));
    }
}