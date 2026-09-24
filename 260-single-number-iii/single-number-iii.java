class Solution {
    public int[] singleNumber(int[] a) {
        int xor = 0;
        for(int ele : a) {
            xor ^= ele;
        }
        int mask = (xor&(xor-1))^xor;
        int b1 = 0;
        int b2 = 0;
        for(int ele : a) {
            if((ele&mask)!=0) b1^=ele;
            else b2^=ele;
        }
        int[] ans = {b1,b2};
        return ans;
    }
}