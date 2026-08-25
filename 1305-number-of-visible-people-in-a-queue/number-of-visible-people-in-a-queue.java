class Solution {
    public int[] canSeePersonsCount(int[] arr) {
        // int n = heights.length;
        // int[] ans = new int[n];
        // for (int i = 0; i < n; i++) {
        //     int count = 0;
        //     int max = 0;
        //     for (int j = i + 1; j < n; j++) {
        //         if (heights[j] > max) {
        //             count++;
        //             max = heights[j];
        //         }
        //         // first person taller than current person
        //         if (heights[j] > heights[i]) break;
        //     }
        //     ans[i] = count;
        // }
        // return ans;
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(arr[n-1]);
        ans[n-1] = 0;
        for(int i=n-2;i>=0;i--) {
            int count = 0;
            while(st.size()>0 && st.peek()<=arr[i]) {
                count++;
                st.pop();
            }
            if(st.size() > 0) count++;
            ans[i] = count;
            st.push(arr[i]);
        }
        return ans;
    }
}