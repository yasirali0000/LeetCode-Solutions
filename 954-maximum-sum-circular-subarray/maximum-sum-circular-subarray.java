class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int minsum = 0;
        int maxsum = 0;
        int totalsum = 0;
        for(int i=0;i<n;i++) {
            totalsum += nums[i];
            minsum += nums[i];
            min = Math.min(min,minsum);
            if(minsum>0) minsum = 0;

            maxsum += nums[i];
            max = Math.max(max,maxsum);
            if(maxsum<0) maxsum = 0;
        }
        if(max < 0) return max;
        return Math.max(max, totalsum - min);
    }
}