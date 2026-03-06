class Solution {
    public boolean validPalindrome(String s) {
        int count = 0;

        int l =0;
        int r = s.length()-1;
        return isValid(s, l, r,0);
    }

    boolean isValid(String s, int l, int r, int count) {

        if(count>1) {
            return false;
        }

        if(l >= r) {
            return true;
        }

        if (s.charAt(l) == s.charAt(r)) {
            return isValid(s, l+1, r-1, count);
        }

        return isValid(s,l+1,r, count+1) || isValid(s, l, r-1, count+1);
    }
}