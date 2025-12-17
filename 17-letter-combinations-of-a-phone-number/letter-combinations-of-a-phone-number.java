class Solution {
    Map<Character, List<Character>> map = new HashMap();
    List<String> ans = new ArrayList();
    public List<String> letterCombinations(String digits) {
        map(map);  
        List<String> result = new ArrayList();
        comb(result, 0, digits);
        return ans;  
    }

    void comb(List<String> result, int index, String digits) {
        if(index == digits.length()) {
            String val = result.stream().collect(Collectors.joining());
            ans.add(val);
            return;
        }

        char cur = digits.charAt(index);
        for(char ele:map.get(cur)) {
            result.add(String.valueOf(ele));
            comb(result, index+1, digits);
            result.removeLast();
        }
    }



    void map(Map<Character, List<Character>> map) {
        map.put('2', Arrays.asList('a','b','c'));
        map.put('3', Arrays.asList('d','e','f'));
        map.put('4', Arrays.asList('g','h','i'));
        map.put('5', Arrays.asList('j','k','l'));
        map.put('6', Arrays.asList('m','n','o'));
        map.put('7', Arrays.asList('p','q','r','s'));
        map.put('8', Arrays.asList('t','u','v'));
        map.put('9', Arrays.asList('w','x','y','z'));
    }
}