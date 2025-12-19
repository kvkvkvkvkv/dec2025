class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> map = new HashMap();

        for(String cur:words) {
            for(char ele:cur.toCharArray()) {
                map.putIfAbsent(ele, new HashSet());
            }
        }

        for(int i=1;i<words.length;i++) {
            int min = Math.min(words[i].length(),words[i-1].length());
            int j=0;
            while(j<min && words[i].charAt(j)==words[i-1].charAt(j)) {
                j++;
            }
            if(j==min && words[i].length()<words[i-1].length()) {
                return "";
            }

            if(j<min) {
                map.get(words[i].charAt(j)).add(words[i-1].charAt(j));
            }
        }

        boolean[] stack = new boolean[26];
        boolean[] seen = new boolean[26];
        StringBuffer ans = new StringBuffer();
        for(char key:map.keySet()) {
            if(!seen[key-'a'] && dfs(key,map,seen,stack,ans)) {
                return "";
            }
        }
        return ans.toString();
    }

    boolean dfs(char key, Map<Character,Set<Character>> map, boolean[] seen, boolean[] stack, StringBuffer sb) {
        if(stack[key-'a']) {
            return true;
        }

        if(seen[key-'a']) {
            return false;
        }

        stack[key-'a'] = true;
        seen[key-'a'] = true;
        for(char next:map.getOrDefault(key, new HashSet<>())) {
            if(dfs(next, map, seen, stack, sb)) {
                return true;
            }
        }
        sb.append(key);
        stack[key-'a'] = false;
        return false;
    }
}