class Solution {
    static int[] dp;

    public int rob(int[] arr) {
        int n = arr.length;

        if (n == 1) return arr[0];

        // Case 1: First house included, last excluded
        int case1 = solve(arr, 0, n - 2);

        // Case 2: First house excluded, last included
        int case2 = solve(arr, 1, n - 1);

        return Math.max(case1, case2);
    }

    public int solve(int[] arr, int start, int end) {
        dp = new int[arr.length];
        Arrays.fill(dp, -1);

        return loot(start, arr, end);
    }

    public int loot(int i, int[] arr, int end) {
        if (i > end) return 0;

        if (dp[i] != -1) return dp[i];

        int pick = arr[i] + loot(i + 2, arr, end);
        int skip = loot(i + 1, arr, end);

        return dp[i] = Math.max(pick, skip);
    }
}