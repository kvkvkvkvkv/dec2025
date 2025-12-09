class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap();
        int l = 0;
        int r = 0;
        int n = s.length();
        int max = 0;
        while(r<n) {
            char cur = s.charAt(r);
            if(map.containsKey(cur) && map.get(cur)>=l) {
                l = map.get(cur)+1;
            }
            map.put(cur, r);
            r++;
            max = Math.max(max, r-l);
        }
        return max;
    }
}