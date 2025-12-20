class Solution {
    Integer[] memo;
    public int climbStairs(int n) {
        memo = new Integer[n+1];
        return climbStairs(n,0);
    }

    public int climbStairs(int n, int i) {
        if(i == n) {
            return 1;
        }

        if(i > n) {
            return 0;
        }

        if(memo[i]!=null) {
            return memo[i];
        }
        return memo[i] = climbStairs(n,i+1) +climbStairs(n,i+2);
    }
}