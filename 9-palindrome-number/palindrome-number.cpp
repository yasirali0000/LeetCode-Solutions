class Solution {
public:
    bool isPalindrome(int n) {
        long sum = 0;
        int cr = 0;
        int original = n;
        if (n < 0) return false;
        while(n>0) {
            n /= 10;
            cr = cr+1;
        }
        n = original;
        cr--;
        while(n>0) {
            int last = n%10;
            sum = sum+pow(10,cr)*last;
            n /= 10;
            cr--;
        }
        if(original == sum) return true;
        else return false;
    }
};