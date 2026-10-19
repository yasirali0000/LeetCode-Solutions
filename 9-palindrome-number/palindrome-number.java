class Solution {
    public boolean isPalindrome(int x) {
        int sum = 0;
        int original = x;
        if(x<0) return false;
        while(x>0) {
            int last = x%10;
            sum = sum*10 + last;
            x /= 10;
        }
        return original == sum;
    }
}