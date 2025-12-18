class Solution {
    LinkedList<String> ans = new LinkedList();
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, LinkedList<String>> map = new HashMap();

        for(var ele:tickets) {
            map.computeIfAbsent(ele.get(0), i-> new LinkedList()).add(ele.get(1));
        }

        for(var ele:map.keySet()) {
            Collections.sort(map.get(ele));
        }
        dfs(map,"JFK");
        return ans;
    }

    void dfs(Map<String, LinkedList<String>> map, String node) {
        LinkedList<String> next = map.getOrDefault(node, new LinkedList());
        while(!next.isEmpty()) {
            String top = next.removeFirst();
            dfs(map, top);
        }
        ans.addFirst(node);
    }
}