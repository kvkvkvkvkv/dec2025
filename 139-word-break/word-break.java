class Solution {
    Map<String, Boolean> map = new HashMap();
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length()==0) {
            return true;
        }

        if(map.containsKey(s)) {
            return map.get(s);
        }

        for(String cur:wordDict) {
            if(s.startsWith(cur)) {
                String temp = s.substring(cur.length());
                if(wordBreak(temp, wordDict)) {
                    map.put(s,true);
                    return true;
                }
            }
        }
        map.put(s,false);
        return false;
    }

    // public boolean wordBreak(String s, List<String> wordDict) {
    //     if(s.length()==0) {
    //         return true;
    //     }

    //     for(String cur:wordDict) {
    //         if(s.startsWith(cur)) {
    //             String temp = s.substring(cur.length);
    //             if(wordBreak(s, wordDict)) {
    //                 return true;
    //             }
    //         }
    //     }

    //     return false;
    // }
}