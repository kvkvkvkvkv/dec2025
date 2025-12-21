class Solution {
    Integer[][]memo;
    public int numDistinct(String s, String t) {
        memo = new Integer[s.length()][t.length()];
        return num(s,t,0,0);
    }

    public int num(String s, String t, int i1, int i2) {
        if(i2 == t.length()) {
            return 1;
        }

        if(i1 == s.length()) {
            return 0;
        }

        if(memo[i1][i2] != null) {
            return memo[i1][i2];
        }

        int leave = num(s, t, i1+1, i2);
        int take = 0;
        if(s.charAt(i1)==t.charAt(i2)) {
            take = num(s,t,i1+1, i2+1);
        }
        return memo[i1][i2] = take + leave;
    }
}