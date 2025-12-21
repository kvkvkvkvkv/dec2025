class Solution {
    Integer[][] memo;
    public int maxProfit(int[] prices) {
        memo = new Integer[prices.length][2];
        return max(prices, 0, 1);
    }

    public int max(int[] prices, int index, int buy) {
        if(index >= prices.length) {
            return 0;
        }

        if(memo[index][buy] != null) {
            return memo[index][buy];
        }

        if(buy==1) {
            return memo[index][buy] = Math.max(-prices[index] + max(prices, index+1, 0), 
            max(prices, index+1, 1));
        } else {
            return memo[index][buy] = Math.max(prices[index] + max(prices, index+2, 1), 
            max(prices, index+1, 0));
        }
    }

}