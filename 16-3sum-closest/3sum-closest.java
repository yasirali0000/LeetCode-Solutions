class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int ans = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++) {
            int left = i+1;
            int right = n-1;
            if(i>0 && nums[i]==nums[i-1]) continue;
            while(left<right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(Math.abs(sum-target) < Math.abs(ans-target)) ans = sum;
                if(sum == target) return sum;
                else if(sum < target) left++;
                else right--;
            }
        }
        return ans;
    }
}