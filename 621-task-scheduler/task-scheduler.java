class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> map = new HashMap();

        for(char ele:tasks) {
            map.put(ele, map.getOrDefault(ele,0)+1);
        }

        PriorityQueue<Character> q = new PriorityQueue<>((a,b) -> Integer.compare(map.get(b), map.get(a)));

        for(char key:map.keySet()) {
            q.add(key);
        }

        Queue<Node> buffer = new LinkedList<>();
        int time=0;
        while(!q.isEmpty() || !buffer.isEmpty()) {
            while(!buffer.isEmpty() && time-buffer.peek().index>n) {
                Node top = buffer.poll();
                q.add(top.ele);
            }
            
            if(!q.isEmpty()) {
                char peek = q.poll();
                map.put(peek, map.get(peek)-1);

                if(map.get(peek)==0) {
                    map.remove(peek);
                } else {
                    buffer.add(new Node(peek, time));
                }
            }
            time++;
        }
        return time;
    }
}

class Node {
    char ele;
    int index;
    Node(char ele, int index) {
        this.ele = ele;
        this.index=index;
    }
}