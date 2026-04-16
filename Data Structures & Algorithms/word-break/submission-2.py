class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        if not s:
            return True
        memo = {len(s): True}
        dp = [False] * (len(s) + 1)

        dp[len(s)] = True

        for idx in range(len(s)-1, -1, -1):
            for w in wordDict:
                if idx + len(w) <= len(s) and s[idx: idx+len(w)] == w:
                    dp[idx] = dp[idx + len(w)]
                if dp[idx]:
                    break

        return dp[0]