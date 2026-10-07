class Solution {
    // public int lengthOfLIS(int[] arr) {
    //     int[][] dp = new int[arr.length][arr.length+1];
    //     for(int i=0;i<arr.length;i++) {
    //         for(int j=0;j<arr.length;j++) {
    //             dp[i][j] = -1;
    //         }
    //     }
    //     return helper(0,-1,arr,dp);
    // }
    // public int helper(int idx,int prev,int[] arr,int[][] dp) {
    //     if(idx == arr.length) return 0;
    //     if(dp[idx][prev+1] != -1) return dp[idx][prev+1];
    //     int skip = helper(idx+1,prev,arr,dp);
    //     if(prev != -1 && arr[idx] <= arr[prev]) return dp[idx][prev+1] = skip;
    //     int pick = 1 + helper(idx+1,idx,arr,dp);
    //     return dp[idx][prev+1] = Math.max(pick,skip);
    // }


//     public int lengthOfLIS(int[] arr) {
//         int n = arr.length;
//         int[] dp = new int[n];
//         int maxl = 1;
//         Arrays.fill(dp,1);
//         for(int i=1;i<n;i++) {
//             int max = 0;
//             for(int j = 0;j<i;j++) {
//                 if(arr[j]<arr[i]) max = Math.max(max,dp[j]);
//             }
//             dp[i] += max;
//             maxl = Math.max(maxl,dp[i]);
//         }
//         return maxl;
//     }


    public int lengthOfLIS(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int ele : arr) {
            if(ans.size()==0 || ele>ans.get(ans.size()-1)) ans.add(ele);
            else replace(ele,ans);
        }
        return ans.size();
    }
    public void replace(int ele,ArrayList<Integer> ans) {
        int l=0,h=ans.size()-1;
        while(l<=h) {
            int mid = l+(h-l)/2;
            if(ans.get(mid)>=ele) {
                h=mid-1;
            } else {
                l=mid+1;
            }
            
        }
        ans.set(l,ele);
    }

}