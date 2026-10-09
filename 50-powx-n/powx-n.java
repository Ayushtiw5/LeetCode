class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if( N < 0){
            N = -N;
            return 1.0 / myPowhelper(x, N);
        }
        return myPowhelper( x, N);
       
    }
    private double myPowhelper(double x, long n){
         if( n == 0){
            return 1.0;
        }
        double halfpow = myPowhelper(x, n/2);
        double halfpowsq = halfpow * halfpow;
        if(n % 2 != 0){
            halfpowsq = x * halfpowsq;
        }
        
        return halfpowsq;
    }
}