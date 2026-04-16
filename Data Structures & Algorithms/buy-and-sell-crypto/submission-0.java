class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int n = prices.length;
        for(int i=0; i<n; i++) {
            int boughtPrice = prices[i];
            for(int j = i+1; j< n; j++) {
                if(prices[j] - boughtPrice > maxProfit) {
                    maxProfit = Math.max(maxProfit, prices[j] - boughtPrice);
                }
            }
        }

        return maxProfit;
    }
}
