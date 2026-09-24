class Solution {
    public int matrixScore(int[][] arr) {

        int m = arr.length;
        int n = arr[0].length;

        // Step 1: First column mein har element 1 karo
        for(int i = 0; i < m; i++) {
            if(arr[i][0] == 0) {
                for(int j = 0; j < n; j++) {
                    arr[i][j] = 1 - arr[i][j];
                }
            }
        }

        // Step 2: Har column mein majority 1 rakho
        for(int j = 0; j < n; j++) {

            int zero = 0;
            int ones = 0;

            for(int i = 0; i < m; i++) {
                if(arr[i][j] == 0)
                    zero++;
                else
                    ones++;
            }

            if(zero > ones) {
                for(int i = 0; i < m; i++) {
                    arr[i][j] ^= 1;
                }
            }
        }

        // Step 3: Score calculate karo
        int sum = 0;
        int pow = 1;

        for(int j = n - 1; j >= 0; j--) {

            int ones = 0;

            for(int i = 0; i < m; i++) {
                if(arr[i][j] == 1)
                    ones++;
            }

            sum += pow * ones;
            pow *= 2;
        }

        return sum;
    }
}