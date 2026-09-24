class Solution {
    // public List<List<Integer>> subsets(int[] nums) {
    //     List<List<Integer>> ans = new ArrayList<>();

    //     sub(nums, 0, new ArrayList<>(), ans);

    //     return ans;
    // }

    // public void sub(int[] nums, int i, List<Integer> curr, List<List<Integer>> ans) {

    //     if (i == nums.length) {
    //         ans.add(new ArrayList<>(curr));
    //         return;
    //     }

    //     // element lena
    //     curr.add(nums[i]);
    //     sub(nums, i + 1, curr, ans);

    //     // element remove karna
    //     curr.remove(curr.size() - 1);

    //     // element nahi lena
    //     sub(nums, i + 1, curr, ans);
    // }


    public List<List<Integer>> subsets(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = arr.length;
        int m = 1<<n;
        for(int i=0;i<m;i++) {
            List<Integer> a = new ArrayList<>();
            for(int j=0;j<n;j++) {
                if((i>>j)%2 == 1) a.add(arr[j]);
            }
            ans.add(a);
        }
        return ans;
    }

}