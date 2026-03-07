class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int l = 0;
        int len = 0;
        for(int i=0;i<s.length();i++) {
            char ele = s.charAt(i);

            if(map.containsKey(ele) && map.get(ele)>=l) {
                l = map.get(ele)+1;
            }
            map.put(ele, i);
            len = Math.max(len, i-l+1);
        }
        return len;
    }
}