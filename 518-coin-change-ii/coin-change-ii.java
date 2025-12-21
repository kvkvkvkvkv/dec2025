class Solution {
    Integer[][]memo;
    public int change(int amount, int[] coins) {
        memo = new Integer[amount+1][coins.length];
        return change(amount, coins, 0);
    }

    public int change(int amount, int[] coins, int index) {
        if(index == coins.length) {
            return amount==0?1:0;
        }

        if(memo[amount][index] != null) {
            return memo[amount][index];
        }

        int take = 0;
        if(amount-coins[index]>=0) {
            take = change(amount-coins[index], coins, index);
        }
        int leave = change(amount, coins, index+1);

        return memo[amount][index] = take + leave;
    }
}