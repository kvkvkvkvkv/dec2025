class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int min = prices[0];
        int max = prices[0];
        int profit = 0;
        for(int index=1;index<n;index++) {
            if(min>prices[index]) {
                min = prices[index];
                max = prices[index];
            }
            max = Math.max(prices[index], max);
            profit = Math.max(profit, max-min);
        }
        return profit;
    }
}