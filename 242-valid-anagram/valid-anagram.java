class Solution {
    public boolean isAnagram(String s, String t) {
        
        Map<Character, Integer> map1 = new HashMap();
        Map<Character, Integer> map2 = new HashMap();

        for(char ele: s.toCharArray()) {
            map1.putIfAbsent(ele, 0);
            map1.put(ele, map1.get(ele)+1);
        }

        for(char ele: t.toCharArray()) {
            map2.putIfAbsent(ele, 0);
            map2.put(ele, map2.get(ele)+1);
        }

        if(map1.size()!=map2.size()) {
            return false;
        }

        for(char key:map1.keySet()) {
            int one = map1.get(key);
            int two = map2.getOrDefault(key, 0);

            if(one != two) {
                return false;
            }
        }
        return true;
    }
}