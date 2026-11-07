class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int max = 0;
        int n = nums.length;
        int maxsum = 0;
        int minsum = 0;
        int min = 0;
        for(int i=0;i<n;i++) {
            maxsum += nums[i];
            max = Math.max(max,maxsum);
            if(maxsum<0) maxsum = 0;
            minsum += nums[i];
            min = Math.min(min,minsum);
            if(minsum>0) minsum = 0;
        }
        return Math.max(max,Math.abs(min));
    }
}