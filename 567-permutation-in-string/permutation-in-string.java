class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> count = new HashMap();
        Map<Character, Integer> value = new HashMap();
        
        for(char ele:s1.toCharArray()) {
            count.put(ele, count.getOrDefault(ele,0)+1);
        }

        int l =0;
        for(int r=0;r<s2.length();r++) {
            char cur = s2.charAt(r);
            if(!count.containsKey(cur)) {
                l = r+1;
                value.clear();
                continue;
            }

            value.put(cur, value.getOrDefault(cur,0)+1);

            while(value.get(cur)>count.get(cur)) {
                value.put(s2.charAt(l), value.get(s2.charAt(l))-1);
                l++;
            }

            if(s1.length() == r-l+1) {
                return true;
            }
        }
        return false;
    }
}