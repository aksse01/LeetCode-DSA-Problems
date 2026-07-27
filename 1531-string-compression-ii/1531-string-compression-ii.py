from functools import lru_cache

class Solution:
    def getLengthOfOptimalCompression(self, s, k):
        n = len(s)

        @lru_cache(None)
        def dp(i, k):
            if k < 0:
                return float('inf')
            if i >= n or n - i <= k:
                return 0

            ans = dp(i + 1, k - 1)  # delete s[i]

            cnt = dele = 0
            for j in range(i, n):
                if s[j] == s[i]:
                    cnt += 1
                else:
                    dele += 1
                if dele > k:
                    break
                ans = min(ans, dp(j + 1, k - dele) +
                          1 + (0 if cnt == 1 else len(str(cnt))))
            return ans

        return dp(0, k)
        """
        :type s: str
        :type k: int
        :rtype: int
        """
        