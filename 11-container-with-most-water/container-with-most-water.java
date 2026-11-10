class Solution {
    public int maxArea(int[] arr) {
        int n = arr.length;
        int left = 0;
        int right = n-1;
        int maxarea = 0;
        while(left<right) {
            int width = right-left;
            int length = Math.min(arr[left],arr[right]);
            int area = length * width;
            maxarea = Math.max(maxarea,area);
            if(arr[left]<arr[right]) left++;
            else right--;
        }
        return maxarea;
    }
}