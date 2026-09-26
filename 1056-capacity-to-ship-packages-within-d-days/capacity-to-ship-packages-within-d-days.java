class Solution {
    public int shipWithinDays(int[] arr, int days) {
        int max = Integer.MIN_VALUE, sum = 0;
        for(int ele:arr) {
            max = Math.max(max,ele);
            sum += ele;
        }
        int lo = max, hi = sum, ans = -1;
        while(lo<=hi) {
            int mid = lo + (hi-lo)/2;
            if(days(mid,arr)<=days) {
                hi = mid-1;
                ans=mid;
            } else {
                lo=mid+1;
            }
        }
        return ans;
    }
    static int days(int mid,int[] arr) {
        int days = 0;
        int c = mid;
        for(int ele : arr) {
            if(c>=ele) c-=ele;
            else {
                days++;
                c=mid-ele;
            }
        }
        days++;
        return days;
    }
}