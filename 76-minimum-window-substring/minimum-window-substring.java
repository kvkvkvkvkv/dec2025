class Solution {
    public String minWindow(String s, String t) {
        int l = 0;
        int start = -1;
        int end = -1;

        Map<Character, Integer> tCount = new HashMap();
        Map<Character, Integer> sCount = new HashMap();
        for(int i=0;i<t.length();i++) {
            char cur = t.charAt(i);
            tCount.put(cur, tCount.getOrDefault(cur,0)+1);
        }
        int need = tCount.size();
        int formed = 0;
        int min = Integer.MAX_VALUE;
        for(int r=0;r<s.length();r++) {
            char cur = s.charAt(r);
            sCount.put(cur, sCount.getOrDefault(cur,0)+1);

            if(sCount.get(cur).equals(tCount.get(cur))) {
                formed++;
            }

            while(formed == need) {
                char temp = s.charAt(l);
                int val = sCount.get(temp)-1;
                sCount.put(temp, val);
                
                if(min>r-l+1) {
                    start = l;
                    end = r;
                    min = r-l+1;
                }

                if(val<tCount.getOrDefault(temp,0)) {
                    formed--;
                }
                l++;
            }
        }

        return start==-1?"":s.substring(start,end+1);
    }
}