class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n];
        for (int[] book : bookings) {
            int start = book[0];
            int end = book[1];
            int seats = book[2];
            diff[start - 1] += seats;
            if (end < n)
                diff[end] -= seats;
        }
        for (int i = 1; i < n; i++) {
            diff[i] += diff[i - 1];
        }
        return diff;
    }
}