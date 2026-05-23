class Solution {
    public double myPow(double x, int n) {
        if ( x == 0.0) return x;
        if (n == 0) return new Double(1);
        double res = 1;
        while (n != 0) {
            if (n > 0) {
                res *= x;
                n -= 1;
            } else {
                res /= x;
                n += 1;
            }
        }

        return res;
    }
}
