class Solution {
    // static int[] dp;
    // public int rob(int[] arr) {
    //     int n = arr.length;
    //     dp = new int[n];
    //     Arrays.fill(dp,-1);
    //     return loot(0,arr);
    // }
    // public int loot(int i,int[] arr) {
    //     if(i>=arr.length) return 0;
    //     if(dp[i]!=-1) return dp[i];
    //     int pick = arr[i] + loot(i+2,arr);
    //     int skip = loot(i+1,arr);
    //     return dp[i] = Math.max(pick,skip);
    // }

    // public int rob(int[] arr) {
    //     int n = arr.length;
    //     int[] dp = new int[n];
    //     dp[0] = arr[0];
    //     if(n>1) dp[1] = Math.max(dp[0],arr[1]);
    //     for(int i=2;i<n;i++) {
    //         dp[i] = Math.max(arr[i]+dp[i-2],dp[i-1]);
    //     }
    //     return dp[n-1];
    // }

    public int rob(int[] arr) {
        int n = arr.length;
        int[] dp = new int[3];
        dp[0] = arr[0];
        if(n==1) return arr[0];
        if(n>1) dp[1] = Math.max(dp[0],arr[1]);
        if(n==2) return dp[1];
        for(int i=2;i<n;i++) {
            dp[2] = Math.max(arr[i]+dp[0],dp[1]);
            dp[0] = dp[1];
            dp[1] = dp[2];
        }
        return dp[2];
    }
}