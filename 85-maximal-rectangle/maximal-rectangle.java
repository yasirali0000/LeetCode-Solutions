class Solution {

    public int largestRectangleArea(int[] arr) {
        int n = arr.length;

        int[] nse = new int[n];
        nse[n - 1] = n;

        Stack<Integer> st = new Stack<>();
        st.push(n - 1);

        // Next Smaller Element
        for (int i = n - 2; i >= 0; i--) {
            while (st.size() > 0 && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (st.size() == 0)
                nse[i] = n;
            else
                nse[i] = st.peek();

            st.push(i);
        }

        while (st.size() > 0)
            st.pop();

        int[] pse = new int[n];
        pse[0] = -1;
        st.push(0);

        // Previous Smaller Element
        for (int i = 1; i < n; i++) {
            while (st.size() > 0 && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (st.size() == 0)
                pse[i] = -1;
            else
                pse[i] = st.peek();

            st.push(i);
        }

        int maxs = 0;

        for (int i = 0; i < n; i++) {
            int area = arr[i] * (nse[i] - pse[i] - 1);
            maxs = Math.max(maxs, area);
        }

        return maxs;
    }

    public int maximalRectangle(char[][] matrix) {

        if (matrix.length == 0)
            return 0;

        int m = matrix.length;
        int n = matrix[0].length;

        int[] arr = new int[n];

        int max = 0;

        for (int i = 0; i < m; i++) {

            // Histogram heights update karna
            for (int j = 0; j < n; j++) {

                if (matrix[i][j] == '1')
                    arr[j]++;
                else
                    arr[j] = 0;
            }

            // Current row ko histogram maan ke
            // largest rectangle find karo
            int area = largestRectangleArea(arr);

            max = Math.max(max, area);
        }

        return max;
    }
}