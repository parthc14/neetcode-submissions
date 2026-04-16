class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        if not s:
            return True
        memo = {len(s): True}

        def dfs(idx):
            if idx == len(s):
                return True

            if idx in memo:
                return memo[idx]
            
            
            for w in wordDict:
                if idx + len(w) <= len(s) and s[idx: idx + len(w)] == w:
                    if dfs(idx + len(w)):
                        memo[idx] = True
                        return True
            memo[idx] = False
            return False


        return dfs(0)