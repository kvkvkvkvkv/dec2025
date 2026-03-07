class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int len = 0;
        int maxf = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            char ele = s.charAt(i);
            map.put(ele, map.getOrDefault(ele, 0)+1);
            maxf = Math.max(maxf, map.get(ele));

            if(i-l+1-maxf>k) {
                char start = s.charAt(l);
                map.put(start,map.get(s.charAt(l))-1);
                l++;
            }
            len = Math.max(len, i-l+1);
        }
        return len;
    }
}