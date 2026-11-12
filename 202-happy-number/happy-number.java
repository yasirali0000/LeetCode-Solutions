class Solution {
    public boolean isHappy(int n) {
        int sum = 0;
        if(n==1) return true;
        if(n==4) return false;
        while(n>0) {
            int rem = n%10;
            sum += rem*rem;
            n /= 10;
        }
        return isHappy(sum);
    }
}