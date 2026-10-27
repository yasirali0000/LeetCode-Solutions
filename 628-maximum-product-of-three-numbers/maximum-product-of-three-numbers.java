class Solution {
    public int maximumProduct(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;

        return Math.max(
            arr[n-1] * arr[n-2] * arr[n-3],
            arr[0] * arr[1] * arr[n-1]
        );
    }
}