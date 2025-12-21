class Solution {
    Boolean[][] memo;
    public boolean checkValidString(String s) {
        memo = new Boolean[s.length()+1][s.length()];
        return valid(s,0,0);
    }

    public boolean valid(String s, int open, int index) {
        if(index == s.length()) {
            return open == 0;
        }

        if(open < 0) {
            return false;
        }

        if(memo[open][index] != null) {
            return memo[open][index];
        }

        char cur = s.charAt(index);

        if(cur == '(') {
            return memo[open][index] = valid(s, open+1, index+1);
        }

        if(cur == ')') {
            return memo[open][index] = valid(s, open-1, index+1);
        }

        return memo[open][index] = valid(s, open+1, index+1) || valid(s, open-1, index+1) ||
        valid(s, open, index+1);
    }
}