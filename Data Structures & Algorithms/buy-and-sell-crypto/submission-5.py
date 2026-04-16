class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        max_profit = 0
        if not prices:
            return max_profit

        for i in range(len(prices)):
            curr_profit = 0
            for j in range(i+1, len(prices)):
                buy_price = prices[i]
                sell_price = prices[j]

                if sell_price - buy_price > curr_profit:
                    curr_profit = sell_price - buy_price
            
            max_profit = max(max_profit, curr_profit)
        
        return max_profit