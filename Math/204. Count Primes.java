// sieve of Eratosthenes
// t:n * sqrt(n) s:n
class Solution {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int res = 0;
        for (int i=2; i<n; i++) {
            if (!notPrime[i]) {
                res ++;
                for (int j=2; i*j<n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }
        return res;
    }
}