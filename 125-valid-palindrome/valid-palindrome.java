class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int n = s.length();
        int l  = 0;
        int r = n-1;

        while(l<r) {
            while(l<r && isInvalid(s.charAt(l))) {
                l++;
            }

            while(r>l && isInvalid(s.charAt(r))) {
                r--;
            }
            
            if(s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    boolean isInvalid(char cur) {
        return !(cur>='a' && cur<='z' || cur>='0' && cur<='9');
    }
}