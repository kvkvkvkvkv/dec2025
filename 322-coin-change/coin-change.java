class Solution {
    Integer[][] memo;
    public int coinChange(int[] coins, int amount) {
        memo = new Integer[amount+1][coins.length];
        int ans = coin(coins, amount, 0);
        return ans==(int)1e9?-1:ans;
    }
    
    public int coin(int[] coins, int amount, int index) {
        if(index == coins.length) {
            return amount==0?0:(int)1e9;
        }

        if(memo[amount][index] != null) {
            return memo[amount][index];
        }
        int leave = coin(coins, amount, index+1);
        int take = (int)1e9;
        if(amount-coins[index]>=0) {
            take = 1 + coin(coins,amount-coins[index],index);
        }
        return memo[amount][index] = Math.min(take, leave);
    }
}