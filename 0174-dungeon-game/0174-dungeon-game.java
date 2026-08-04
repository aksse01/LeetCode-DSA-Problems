class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n - 1] = 1; // will be computed properly in last row

        for (int i = m - 1; i >= 0; i--) {
            int[] newDp = new int[n + 1];
            Arrays.fill(newDp, Integer.MAX_VALUE);
            for (int j = n - 1; j >= 0; j--) {
                int bestNext;
                if (i == m - 1 && j == n - 1) {
                    newDp[j] = Math.max(1, 1 - dungeon[i][j]);
                    continue;
                }
                // right neighbor: newDp[j+1], below neighbor: dp[j]
                bestNext = Math.min(
                    newDp[j + 1] == Integer.MAX_VALUE ? Integer.MAX_VALUE : newDp[j + 1],
                    dp[j] == Integer.MAX_VALUE ? Integer.MAX_VALUE : dp[j]
                );
                newDp[j] = Math.max(1, bestNext - dungeon[i][j]);
            }
            dp = newDp;
        }

        return dp[0];
    }
}