class Solution {
    // public int maxProduct(int[] nums) {
    //     int n = nums.length;
    //     int max = Integer.MIN_VALUE;
    //     for(int i=0;i<n;i++) {
    //         int prod = 1;
    //         for(int j=i;j<n;j++) {
    //             prod *= nums[j];
    //             max = Math.max(max,prod);
    //         }
    //     }
    //     return max;
    // }

    public int maxProduct(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int min = nums[0];
        int ans = nums[0];
        for(int i=1;i<n;i++) {
            if(nums[i]<0) {
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(nums[i],max*nums[i]);
            min = Math.min(nums[i],min*nums[i]);
            ans = Math.max(ans,max);
        }
        return ans;
    }
}