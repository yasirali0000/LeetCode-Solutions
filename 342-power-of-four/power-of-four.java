class Solution {
    public boolean ispowoftwo(int n) {
        return (n>0 && (n & (n-1))==0);
    }
    public boolean square(int n) {
        int root = (int)Math.sqrt(n);
        return (root*root == n);
    }
    public boolean isPowerOfFour(int n) {
        return ispowoftwo(n) && square(n);
    }
}