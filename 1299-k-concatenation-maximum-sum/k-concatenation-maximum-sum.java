class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        int n = arr.length;
        long total = 0;
        for(int num : arr) {
            total += num;
        }
        long max = 0;
        long sum = 0;
        int copies = Math.min(k,2);
        for(int i=0;i<n*copies;i++) {
            sum += arr[i%n];
            max = Math.max(max,sum);
            if(sum<0) sum = 0;
        }
        if(k>2 && total > 0) max += (long)(k-2)*total;
        return (int)(max%1000000007);
    }
}