class Solution {
    public int singleNumber(int[] arr) {
        int xor = 0;
        for(int ele : arr) {
            xor ^= ele;
        }
        return xor;
    }
}