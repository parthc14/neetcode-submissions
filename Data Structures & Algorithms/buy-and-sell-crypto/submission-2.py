class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        max_profit = 0

        for i in range(len(prices)):
            buy_price = prices[i]

            for j in range(i+1, len(prices)):
                sell = prices[j]

                max_profit = max(max_profit, sell - buy_price)
            
        return max_profit



"""
prices = [10,1,5,6,7,1]
             i
max = 0

buy = 1
sell = 5

0 > 0

"""