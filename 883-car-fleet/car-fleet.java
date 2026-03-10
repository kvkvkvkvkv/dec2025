class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> stack = new Stack<>();

        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<position.length;i++) {
            map.put(position[i],speed[i]);
        }

        Arrays.sort(position);

        for(int i=position.length-1;i>=0;i--) {
            double time = (double)(target - position[i])/ map.get(position[i]);
            
            if(!stack.isEmpty() && time<=stack.peek()) {
                continue;
            }

            stack.add(time);
        }
        return stack.size();
    }
}