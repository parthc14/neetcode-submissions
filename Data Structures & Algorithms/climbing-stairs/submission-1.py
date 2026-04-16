class Solution:
    def climbStairs(self, n: int) -> int:
        memo = {}
        def rec(n):
            if n <= 1:
                return 1
            
            if n in memo:
                return memo[n]

            res = rec(n-1) + rec(n-2) if n-2 >= 0 else 0
            memo[n] = res
            return res

        return rec(n)