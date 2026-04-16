class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        max_profit = 0

        l, r = 0, 1

        for r in range(len(prices)):
            if prices[l] < prices[r]:
                max_profit = max(max_profit, prices[r] - prices[l])
            else:
                l = r

        return max_profit

        



"""
prices = [10,1,5,6,7,1]
             i
max = 0

buy = 1
sell = 5

0 > 0

"""