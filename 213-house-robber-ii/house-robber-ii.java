class Solution {
    static int[] dp;

    public int rob(int[] arr) {
        int n = arr.length;
        if(n == 1) return arr[0];
        int case1 = solve(arr,0,n-2);
        int case2 = solve(arr,1,n-1);
        return Math.max(case1,case2);
    }
    public int solve(int[] arr,int start,int end) {
        dp = new int[arr.length];
        Arrays.fill(dp,-1);
        return loot(arr,start,end);
    }
    public int loot(int[] arr,int i,int end) {
        if(i>end) return 0;
        if(dp[i] != -1) return dp[i];
        int pick = arr[i] + loot(arr,i+2,end);
        int skip = loot(arr,i+1,end);
        return dp[i] = Math.max(pick,skip);
    }
}