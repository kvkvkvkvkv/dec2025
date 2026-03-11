class TimeMap {
    Map<String, List<Node>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList()).add(new Node(key, value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        
        if(map.get(key) == null) {
            return "";
        }

        List<Node> val = map.get(key);
        int l = 0;
        int r = val.size()-1;
        Node ans = null;
        while (l<=r) {
            int mid = l + (r-l)/2;
            Node cur = val.get(mid);
            if(timestamp == cur.time) {
                ans = cur;
                break;
            }
            if(timestamp < cur.time) {
                r = mid-1;
            } else {
                ans = cur;
                l = mid+1;
            }
        }
        return ans == null?"":ans.value;
    }
}

class Node {
    String key;
    String value;
    int time;

    Node(String key, String value, int time) {
        this.key = key;
        this.value = value;
        this.time = time;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */