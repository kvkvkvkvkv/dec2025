class TimeMap {

    Map<String,List<Node>> map;
    public TimeMap() {
        map = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList());
        map.get(key).add(new Node(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        return lowerBound(key, timestamp);
    }

    String lowerBound(String key, int time) {
        String value = "";

        if(!map.containsKey(key)) {
            return value;
        }

        List<Node> nodes = map.get(key);
        int l = 0;
        int r = nodes.size()-1;

        Node temp = null;
        while(l<=r) {

            int mid = l + (r-l)/2;
            Node cur = nodes.get(mid);

            if(cur.time == time) {
                return cur.value;
            }

            if(cur.time<time) {
                temp = cur;
                l = mid+1;
            } else {
                r = mid-1;
            }
        }

        return temp==null?"":temp.value;


    }
}

class Node {
    String value;
    int time;

    Node(String value, int time) {
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