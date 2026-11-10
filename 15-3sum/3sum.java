class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        // Step 1: Sort the array
        Arrays.sort(nums);
        // Step 2: Fix first element
        for(int i = 0; i < n - 2; i++) {
            // Duplicate first elements skip karo
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = n - 1;
            // Step 3: Two pointers
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0) {
                    // Valid triplet store karo
                    ans.add(Arrays.asList(
                        nums[i], nums[left], nums[right]
                    ));
                    left++;
                    right--;
                    // Duplicate left values skip karo
                    while(left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    // Duplicate right values skip karo
                    while(left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
                else if(sum < 0) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        return ans;
    }
}