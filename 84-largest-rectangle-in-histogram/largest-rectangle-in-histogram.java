class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack();
        int max = -1;
        for(int i=0;i<heights.length;i++) {
            int ele = heights[i];

            if(stack.isEmpty() || ele>=heights[stack.peek()]) {
                stack.add(i);
            } else {
                while(!stack.isEmpty() && heights[stack.peek()]>ele) {
                    int top = stack.pop();
                    int dist = 0;
                    if(stack.isEmpty()) {
                        dist = i;
                    } else {
                        dist = i-stack.peek()-1;
                    }
                    max = Math.max(max, dist * heights[top]);
                }
                stack.add(i);
            }
        }  

        while(!stack.isEmpty()) {
            int top = stack.pop();
            int dist = heights.length-top;
            if(stack.isEmpty()) {
                dist = heights.length;
            } else {
                dist = heights.length-stack.peek()-1;
            }
            max = Math.max(max, dist * heights[top]);
        }
        return max;
    }
}