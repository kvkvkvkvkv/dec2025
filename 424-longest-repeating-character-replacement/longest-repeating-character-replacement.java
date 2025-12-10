class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap();
        int n = s.length();
        int l = 0;
        int max = 0;
        int ans = 0;
        for(int r=0;r<n;r++) {
            char cur = s.charAt(r);
            int val = map.getOrDefault(cur,0)+1;
            max = Math.max(max, val);
            map.put(cur, val);

            if(r-l+1-max>k) {
                char temp = s.charAt(l);
                map.put(temp, map.get(temp)-1);
                l++;
            }
            ans = Math.max(ans, r-l+1);
        }
        return ans;
    }
}