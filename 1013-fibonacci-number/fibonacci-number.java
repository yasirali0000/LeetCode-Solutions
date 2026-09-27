class Solution {
    // static int[] dp;

    // public int fib(int n) {
    //     dp = new int[n + 1];

    //     return solve(n);
    // }

    // public int solve(int n) {
    //     if(n <= 1) return n;

    //     if(dp[n] != 0) return dp[n];

    //     dp[n] = solve(n - 1) + solve(n - 2);

    //     return dp[n];
    // }

    public int fib(int n) {
        int[] dp = new int[n+1];
        if(n>=1) dp[1] = 1;
        for(int i=2;i<=n;i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}