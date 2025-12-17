class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, Set<String>> map = new HashMap();

        boolean found = false;
        for(String ele:wordList) {
            if(ele.equals(endWord)) {
                found = true;
            }
            char[] temp = ele.toCharArray();
            for(int i=0;i<ele.length();i++) {
                char t = temp[i];
                temp[i] = '*';
                String key = String.valueOf(temp);
                map.computeIfAbsent(key, o -> new HashSet<>()).add(ele);
                temp[i] = t;
            }
        }

        if(!found) {
            return 0;
        }

        Queue<String> q = new LinkedList();
        Set<String> seen = new HashSet();
        seen.add(beginWord);
        q.add(beginWord);
        int count = 0;
        while(!q.isEmpty()) {
            int size = q.size();

            while(size>0) {
                String top = q.poll();

                if(top.equals(endWord)) {
                    return count+1;
                }

                char[] val = top.toCharArray();
                for(int i=0;i<val.length;i++) {
                    char t = val[i];
                    val[i] = '*';
                    String key = String.valueOf(val);

                    for(String next:map.getOrDefault(key, new HashSet<>())) {
                        if(!seen.contains(next)) {
                            q.add(next);
                            seen.add(next);
                        }
                    }
                    val[i] = t;
                }
                size--;
            }
            count++;
        }
        return 0;

    }
}