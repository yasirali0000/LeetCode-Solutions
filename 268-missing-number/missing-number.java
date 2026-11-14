class Solution {
    public int missingNumber(int[] nums) {
        //     int n = arr.length;
        //     int i = 0;
        //     while(i<n) {
        //         if(arr[i]==i ||  arr[i] < 0 || arr[i] >= n) i++;
        //         else {
        //             int idx = arr[i];
        //             swap(arr,i,idx);
        //         }
        //     }
        //     for(i = 0;i<arr.length;i++) {
        //         if(arr[i] != i) return i;
        //     }
        //     return n;
        // }
        // void swap(int[] arr,int i, int idx) {
        //     int temp = arr[i];
        //     arr[i] = arr[idx];
        //     arr[idx] = temp;
        int n = nums.length;
        int sum = n * (n + 1) / 2;
        int x = 0;
        for (int i = 0; i < nums.length; i++) {
            x = x + nums[i];
        }
        int ans = sum - x;
        return ans;
    }

}