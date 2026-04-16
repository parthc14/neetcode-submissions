class Solution {
    int maxCost = (int) 1e9;
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int cost = f(0, coins, amount);
        return cost == maxCost ? -1 : cost;  
    }

    public int f(int startIdx, int[] coins, int target) {
        if(target < 0 || startIdx == coins.length) return maxCost;

        if(target == 0) return 0;

        int take = 1 + f(startIdx, coins, target - coins[startIdx]);
        int skip = 0 + f(startIdx + 1, coins, target);


        return Math.min(take, skip);
    }
}
