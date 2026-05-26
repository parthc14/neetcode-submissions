class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        memo = {}
        
        def f(idx, amnt):
            if amnt == 0:
                return 0
            
            if idx == len(coins) or amnt < 0:
                return float('inf')
            
            if (idx, amnt) in memo:
                return memo[(idx, amnt)]
            
            non_pick = 0 + f(idx+1, amnt)
            pick = float('inf')
            if amnt - coins[idx] >= 0:
                pick = 1 + f(idx, amnt - coins[idx])
            
            res = min(pick, non_pick)
            memo[(idx, amnt)] = res
            return res
            
        return -1 if f(0, amount) == float('inf') else f(0, amount)