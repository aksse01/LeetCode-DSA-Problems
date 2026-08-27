class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int k = primes.length;

        int[] dp = new int[n];
        int[] idx = new int[k];

        // The first super ugly number is 1.
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            long next = Long.MAX_VALUE;

            // Find the smallest candidate.
            for (int j = 0; j < k; j++) {
                long candidate = (long) dp[idx[j]] * primes[j];
                next = Math.min(next, candidate);
            }

            dp[i] = (int) next;

            // Advance every pointer that produced this value.
            for (int j = 0; j < k; j++) {
                long candidate = (long) dp[idx[j]] * primes[j];

                if (candidate == next) {
                    idx[j]++;
                }
            }
        }

        return dp[n - 1];
    }
}