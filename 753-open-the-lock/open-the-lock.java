class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> skip = Arrays.stream(deadends).collect(Collectors.toSet());
        Queue<Pair<String,Integer>> q = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        Map<Character,List<Character>> map = new HashMap();
        init(map);
        String start = "0000";
        if(skip.contains(target) || skip.contains(start)) {
            return -1;
        }
        q.add(new Pair<>(start,0));
        seen.add(start);

        while(!q.isEmpty()) {
            Pair<String, Integer> top = q.poll();
            String key = top.getKey();
            int value = top.getValue();

            if(target.equals(key)) {
                return value;
            }

            for(int i=0;i<4;i++) {
                char cur = key.charAt(i);
                for(char next:map.get(cur)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(key.substring(0,i));
                    sb.append(next);
                    sb.append(key.substring(i+1));
                    String child = sb.toString();
                    if(!seen.contains(child) && !skip.contains(child)) {
                        q.add(new Pair<>(child, value+1));
                        seen.add(child);
                    }
                }
            }
        }
        return -1;
    }

    void init(Map<Character,List<Character>> map) {
        for (int i = 0; i <= 9; i++) {
            char current = (char) ('0' + i);

            List<Character> neighbors = map.computeIfAbsent(current, k -> new ArrayList<>());

            char plusOne = (char) ('0' + ((i + 1) % 10));
            char minusOne = (char) ('0' + ((i + 9) % 10)); // same as (i - 1 + 10) % 10

            neighbors.add(plusOne);
            neighbors.add(minusOne);
        }

    }
}