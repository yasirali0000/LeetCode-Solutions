class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(nums[0]);
        for(int i=1;i<n;i++) {
            if(nums[i] != nums[i-1]) ans.add(nums[i]);
        }
        int x = ans.size();
        for(int i=0;i<x;i++) {
            nums[i] = ans.get(i);
        }
        return x;
    }
}