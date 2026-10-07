class Solution {
    public double myPow(double x, int n) {
        long N = n;
        double res = helper(x, Math.abs(N));

        if (N < 0) {
            return 1 / res;
        }
        return res;
    }
    private double helper(double x, long n){
           if(n == 0){
            return 1;
           }
           double half = helper(x, n/2);
           if(n % 2 == 0){
            return half * half;
           }
           return x * half * half;

        }
}