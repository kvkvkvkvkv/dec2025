class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> c1 = new HashMap<>();
        Map<Character,Integer> c2 = new HashMap<>();

        for(char ele:s1.toCharArray()) {
            c1.put(ele, c1.getOrDefault(ele, 0)+1);
        }

        int l = -1;
        for(int i=0;i<s2.length();i++) {
            char cur = s2.charAt(i);

            if(!c1.containsKey(cur)) {
                c2.clear();
                l = -1;
            } else {
                if(l == -1) {
                    l = i;
                }
                c2.put(cur, c2.getOrDefault(cur, 0)+1);
                while(c2.get(cur)>c1.get(cur)) {
                    c2.put(s2.charAt(l), c2.get(s2.charAt(l))-1);
                    if(c2.get(s2.charAt(l)) == 0) {
                        c2.remove(s2.charAt(l));
                    }
                    l++;
                }
            } 

            if(c2.equals(c1)) {
                return true;
            }
        }

        return false;
    }
}