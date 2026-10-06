class Solution {
    public int lengthOfLIS(int[] arr) {
        int[][] dp = new int[arr.length][arr.length+1];
        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr.length;j++) {
                dp[i][j] = -1;
            }
        }
        return helper(0,-1,arr,dp);
    }
    public int helper(int idx,int prev,int[] arr,int[][] dp) {
        if(idx == arr.length) return 0;
        if(dp[idx][prev+1] != -1) return dp[idx][prev+1];
        int skip = helper(idx+1,prev,arr,dp);
        if(prev != -1 && arr[idx] <= arr[prev]) return dp[idx][prev+1] = skip;
        int pick = 1 + helper(idx+1,idx,arr,dp);
        return dp[idx][prev+1] = Math.max(pick,skip);
    }
}