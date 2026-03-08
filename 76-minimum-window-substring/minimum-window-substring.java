class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> ct = new HashMap<>();
        Map<Character,Integer> cs = new HashMap<>();

        for(char ele:t.toCharArray()) {
            ct.put(ele, ct.getOrDefault(ele, 0)+1);
        }
        int l =0;
        int need = ct.size();
        int have = 0;
        int min = Integer.MAX_VALUE;
        int l1 = -1;
        int l2 = -1;
        for(int i=0;i<s.length();i++) {
            char ele = s.charAt(i);
            cs.put(ele, cs.getOrDefault(ele, 0)+1);

            if(ct.containsKey(ele) && cs.get(ele).equals(ct.get(ele))) {
                have++;
            }

            while(have == need) {
                char val = s.charAt(l);
                if(min>i-l+1) {
                    min = i-l+1;
                    l1 = l;
                    l2 = i;
                }
                cs.put(val, cs.get(val)-1);
                if(ct.containsKey(val) && cs.get(val)<ct.get(val)) {
                    have--;
                }
                l++;
            }
        }
        return l1==-1?"":s.substring(l1,l2+1);
    }
}