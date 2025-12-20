class Solution {

    public String longestPalindrome(String s) {
        int l = 0;
        int r = 0;
        int max = 1;
        for(int i=1;i<s.length();i++) {
            int v1 = palin(s, i, i);
            int v2 = palin(s, i-1, i);

            if(max<v1) {
                max = v1;
                l = i-(v1/2);
                r = i+(v1/2);
            }

            if(max<v2) {
                max = v2;
                l = i-(v2/2);
                r = i+(v2/2)-1;
            }
        }
        return s.substring(l,r+1);
    }

    int palin(String s, int i, int j) {
        while(i>=0 && j<s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j-i-1;
    }

}