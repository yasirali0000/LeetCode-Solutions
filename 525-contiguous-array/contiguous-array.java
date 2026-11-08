class Solution {
    public int findMaxLength(int[] nums) {
        // Key = Prefix Sum
        // Value = Prefix Sum ka first occurrence index
        HashMap<Integer, Integer> map = new HashMap<>();
        // Initially sum = 0 ko index -1 par store kar rahe hain
        // Taaki index 0 se start hone wale subarrays bhi count hon
        map.put(0, -1);
        // Running Prefix Sum
        int sum = 0;
        // Maximum balanced subarray ki length
        int max = 0;
        // Array ko ek baar traverse karenge
        for(int i = 0; i < nums.length; i++) {
            // 0 ko -1 maan rahe hain
            // 1 ko +1 maan rahe hain
            if(nums[i] == 0) {
                sum--;
            } else {
                sum++;
            }
            // Check kar rahe hain ki current sum pehle aaya hai ya nahi
            if(map.containsKey(sum)) {
                // Same sum dobara mila:
                // Current index - First occurrence index
                // Isse balanced subarray ki length milegi
                int len = i - map.get(sum);
                // Maximum length update karenge
                max = Math.max(max, len);
            } else {
                // Agar sum pehli baar aaya hai,
                // toh uska index HashMap mein store karenge
                map.put(sum, i);
            }
        }
        // Longest balanced subarray ki length return
        return max;
    }
}