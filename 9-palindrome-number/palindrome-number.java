class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int sum = 0;
        int original = x;
        while(x>0) {
            int last = x%10;
            sum = sum*10 + last;
            x /= 10;
        }
        return original == sum;
    }
}