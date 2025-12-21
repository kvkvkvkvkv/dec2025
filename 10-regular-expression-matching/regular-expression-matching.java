class Solution {
    Boolean[][] memo;
    public boolean isMatch(String s, String p) {
        memo = new Boolean[s.length()+1][p.length()+1];
        return match(s,p,0,0);
    }

    public boolean match(String s, String p, int i1, int i2) {
        if(i2 == p.length()) {
            return i1 == s.length();
        }

        if(memo[i1][i2] != null) {
            return memo[i1][i2];
        }
        
        boolean firstMatch = (i1 < s.length() &&
                (p.charAt(i2) == s.charAt(i1) || p.charAt(i2) == '.'));        

        if(i2+1 < p.length() && p.charAt(i2+1) == '*') {
            return memo[i1][i2] = match(s,p,i1,i2+2) || firstMatch && match(s,p,i1+1,i2);
        }

        return memo[i1][i2] = firstMatch && match(s,p,i1+1,i2+1);
    }
}