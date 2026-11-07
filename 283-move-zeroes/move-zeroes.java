class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int j = 0;
        for(int i=0;i<n;i++) {
            if(nums[i] != 0) {
                ans[j] = nums[i];
                j++;
            }
        }
        for(int i=j;i<n;i++) {
            ans[i] = 0;
        }
        for(int i=0;i<n;i++) {
            nums[i] = ans[i];
        }
    }
}