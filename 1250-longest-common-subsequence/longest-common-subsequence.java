class Solution {
    Integer[][] memo;
    public int longestCommonSubsequence(String text1, String text2) {
        memo = new Integer[text1.length()][text2.length()];
        return lcs(text1, text2, 0, 0);
    }

    public int lcs(String text1, String text2, int i, int j) {
        if(i==text1.length() || j==text2.length()) {
            return 0;
        }

        if(memo[i][j] != null) {
            return memo[i][j];
        }

        char t1 = text1.charAt(i);
        char t2 = text2.charAt(j);

        if(t1 == t2) {
            return memo[i][j] = 1 + lcs(text1, text2, i+1, j+1);
        }
        return  memo[i][j] = Math.max(lcs(text1, text2, i+1, j), lcs(text1, text2, i, j+1));
    }
}