class Solution {
    public int findTargetSumWays(int[] arr, int sum) {
        return helper(0,sum,arr);
    }
    public int helper(int i,int sum,int arr[]) {
        if(i==arr.length) {
            if(sum == 0) return 1;
            else return 0;
        }
        int add = helper(i+1,sum-arr[i],arr);
        int sub = helper(i+1,sum+arr[i],arr);
        return sub+add;
    }
}