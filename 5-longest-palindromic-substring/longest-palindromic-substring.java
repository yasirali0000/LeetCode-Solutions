class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        int maxl = 1;
        for(int i=0;i<n;i++) {
            int row = 0;
            for(int col = i;col<n;col++) {
                if(row == col) dp[row][col] = 1;
                else if(s.charAt(row)==s.charAt(col)) {
                    if(col==row+1) dp[row][col] = 2;
                    else if(dp[row+1][col-1] != 0) dp[row][col] = dp[row+1][col-1] + 2;
                }
                maxl = Math.max(maxl,dp[row][col]);
                row++;
            }
        }
        String ans = "";
        for(int i=0;i<n;i++) {
            int row = 0;
            for(int col = i;col<n;col++,row++) {
                if(dp[row][col] == maxl) {
                    ans = s.substring(row,col+1);
                    return ans;
                }
            }
        }
        return ans;
    }
}