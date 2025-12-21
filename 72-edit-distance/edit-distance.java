class Solution {
    Integer[][] memo;
    public int minDistance(String word1, String word2) {
        memo = new Integer[word1.length()][word2.length()];
        return min(word1, word2, 0,0);
    }

    public int min(String word1, String word2, int i1, int i2) {
        if(word2.length() == i2) {
            return word1.length() - i1;
        }

        if(word1.length() == i1) {
            return word2.length()-i2;
        }

        if(memo[i1][i2] != null) {
            return memo[i1][i2];
        }

        char v1 = word1.charAt(i1);
        char v2 = word2.charAt(i2);

        if(v1 == v2) {
            return memo[i1][i2] = min(word1, word2, i1+1, i2+1);
        }

        int op1 = 1 + min(word1, word2, i1, i2+1);
        int op2 = 1 + min(word1, word2, i1+1, i2);
        int op3 = 1 + min(word1, word2, i1+1, i2+1);
        return memo[i1][i2] = Math.min(Math.min(op1,op2),op3);
    }
}