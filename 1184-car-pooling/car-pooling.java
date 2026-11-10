class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] dif = new int[1001];
        for(int[] trip : trips) {
            int passenger = trip[0];
            int from = trip[1];
            int to = trip[2];
            dif[from] += passenger;
            dif[to] -= passenger;
        }
        int passengercount = 0;
        for(int i=0;i<1001;i++) {
            passengercount += dif[i];
            if(passengercount > capacity) return false;
        }
        return true;
    }
}