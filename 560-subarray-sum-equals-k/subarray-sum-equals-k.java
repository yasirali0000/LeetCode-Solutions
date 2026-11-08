class Solution {

    // brute force gives TLE
    // public int subarraySum(int[] nums, int k) {
    //     int n = nums.length;
    //     int[] prefix = new int[n];
    //     prefix[0] = nums[0];
    //     for(int i=1;i<n;i++) {
    //         prefix[i] = prefix[i-1] + nums[i];
    //     }
    //     int c = 0;
        
    //     for(int left=0;left<n;left++) {
    //         for(int right=left;right<n;right++) {
    //             int subarraysum;
    //             if(left==0) subarraysum = prefix[right];
    //             else subarraysum = prefix[right] - prefix[left-1];
    //             if(subarraysum == k) c++;
    //         }
    //     }
    //     return c;
    //}

    public int subarraySum(int[] nums, int k) {
        // Key = Prefix Sum
        // Value = Us Prefix Sum ki frequency (kitni baar aaya)
        HashMap<Integer, Integer> map = new HashMap<>();
        // Initially prefix sum 0 ko 1 baar store kar rahe hain
        map.put(0, 1);
        // Running Prefix Sum
        int sum = 0;
        // K ke equal subarrays ki total counting
        int count = 0;
        // Array ko ek hi baar traverse karenge
        for(int i = 0; i < nums.length; i++) {
            // Current element ko running sum mein add karna
            sum += nums[i];
            // Check karna ki (sum - k) pehle kitni baar aaya hai
            // Utni baar valid subarray exist karti hai
            count += map.getOrDefault(sum - k, 0);
            // Current prefix sum ki frequency increase karna
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        // Total valid subarrays return
        return count;
    }
}