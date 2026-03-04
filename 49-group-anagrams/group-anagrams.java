class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String ele:strs) {
            char[] value = ele.toCharArray();
            int[] count = new int[26];
            for(char v:value) {
                count[v-'a']++;
            }
            String key = Arrays.toString(count);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(ele);
        }

        List<List<String>> ans = new ArrayList<>();
        for(String key:map.keySet()) {
            ans.add(map.get(key));
        }
        return ans;
    }
}