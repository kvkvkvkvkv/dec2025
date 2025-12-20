class Solution {
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(cost(cost,0,new Integer[cost.length]),cost(cost,1,new Integer[cost.length]));
    }

    public int cost(int[] cost, int index, Integer[] memo) {
        if(index >= cost.length) {
            return 0;
        }

        if(memo[index]!=null) {
            return memo[index];
        }

        return memo[index] = cost[index] + Math.min(cost(cost,index+1,memo),cost(cost,index+2,memo));
    }
}