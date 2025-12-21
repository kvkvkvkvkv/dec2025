class Solution {
    Boolean[][][] memo;
    public boolean isInterleave(String s1, String s2, String s3) {
        memo = new Boolean[s1.length()][s2.length()][s3.length()];
        if(s1.length()+s2.length() != s3.length()) {
            return false;
        }
        return leave(s1,s2,s3,0,0,0);
    }

    public boolean leave(String s1, String s2, String s3, int i1, int i2, int i3) {
        if(i1 == s1.length()) {
            while (i2 < s2.length()) {
                if (s2.charAt(i2) != s3.charAt(i3)) return false;
                i2++; i3++;
            }
            return true;
        }

        if(i2 == s2.length()) {
            while (i1 < s1.length()) {
                if (s1.charAt(i1) != s3.charAt(i3)) return false;
                i1++; i3++;
            }
            return true;
        }

        if(memo[i1][i2][i3] != null) {
            return memo[i1][i2][i3];
        }

        char f = s1.charAt(i1);
        char s = s2.charAt(i2);
        char t = s3.charAt(i3);

        if(f!=t && t!=s) {
            return false;
        }

        boolean ans = false;
        if(f==s && f==t) {
            ans = leave(s1, s2, s3, i1+1, i2, i3+1) || leave(s1, s2, s3, i1, i2+1, i3+1);
            if(ans) {
                return memo[i1][i2][i3] = ans;
            }
        } else if(f == t) {
            ans = leave(s1, s2, s3, i1+1, i2, i3+1);
            if(ans) {
                return memo[i1][i2][i3] = ans;
            }
        } else if(s == t) {
            ans = leave(s1, s2, s3, i1, i2+1, i3+1);
            if(ans) {
                return memo[i1][i2][i3] = ans;
            }
        }

        return memo[i1][i2][i3] = ans;
    }
}