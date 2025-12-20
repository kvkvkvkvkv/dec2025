class Solution {
    Integer[] memo;
    public int numDecodings(String s) {
        memo = new Integer[s.length()];
        return num(s, 0);
    }

    public int num(String s, int index) {
        if(index == s.length()) {
            return 1;
        }

        String one = s.substring(index, index+1);
        int oneNum = Integer.valueOf(one);
        if(oneNum == 0) {
            return 0;
        }

        if(memo[index] != null) {
            return memo[index];
        }
        int v1 = num(s, index+1);
        int v2 = 0;
        if(index+1<s.length()) {
            String two = s.substring(index, index+2);
            int twoNum = Integer.valueOf(two);
            if(twoNum>=1 && twoNum<=26) {
                v2 = num(s, index+2);
            }
        }
        return memo[index] = v1 + v2;
    }
}