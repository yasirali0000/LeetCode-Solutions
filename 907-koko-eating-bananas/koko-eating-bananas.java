class Solution {
    public int minEatingSpeed(int[] arr, int h) {
        int max = Integer.MIN_VALUE;
        for(int ele:arr) {
            max = Math.max(max,ele);
        }
        int lo = 1, hi = max, speed = max;
        while(lo<=hi) {
            int mid = lo + (hi-lo)/2;
            if(hours(mid,arr)<=h) {
                hi = mid-1;
                speed=mid;
            } else {
                lo=mid+1;
            }
        }
        return speed;
    }
    static long hours(int speed,int[] arr) {
        long h=0;
        for(int ele : arr) {
            if(ele%speed==0) h += ele/speed;
            else h += (ele/speed +1);
        }
        return h;
    }
}