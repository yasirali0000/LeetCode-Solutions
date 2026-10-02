class Solution {
    public void reverseString(char[] s) {
        int n = s.length;
        int lo = 0;
        int hi = n-1;
        while(lo<=hi) {
            char temp = s[lo];
            s[lo] = s[hi];
            s[hi] = temp;
            lo++;
            hi--;
        }
    }
}