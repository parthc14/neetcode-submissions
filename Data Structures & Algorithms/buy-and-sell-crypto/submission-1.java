class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int n = prices.length;
        int previousDayPrice = Integer.MAX_VALUE;
        for(int i=0; i<n; i++) {
            if(previousDayPrice > prices[i]) {
                previousDayPrice = prices[i];
            }

            if(prices[i] - previousDayPrice > maxProfit) {
                maxProfit = prices[i] - previousDayPrice;
            }
        }

        return maxProfit;
    }
}
