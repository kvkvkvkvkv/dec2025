class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        List<Pair<Integer,Double>> time = new ArrayList();
        
        for(int index=0;index<n;index++) {
            double t = target-position[index];
            double val = speed[index];
            double aa = (double)t/val;
            Pair<Integer,Double> cur = new Pair<>(position[index],aa);
            time.add(cur);
        }

        Collections.sort(time, (a,b) -> Integer.compare(b.getKey(),a.getKey()));

        Stack<Pair<Integer,Double>> stack = new Stack();

        int fleet = 0;
        for(Pair<Integer,Double> cur:time) {
            while(!stack.isEmpty() && cur.getValue()>stack.peek().getValue()) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                fleet++;
            }
            stack.add(cur);
        }
        return fleet;
    }
}