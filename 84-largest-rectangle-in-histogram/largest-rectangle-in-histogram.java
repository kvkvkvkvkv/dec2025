class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack();
        int n = heights.length;
        int max = -1;
        for(int index=0;index<n;index++) {
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[index]) {
                int cur = stack.pop();
                int left = -1;
                if(!stack.isEmpty()) {
                    left = stack.peek();
                }
                max = Math.max((index-left-1)*heights[cur],max);
            }
            stack.push(index);
        }

        while(!stack.isEmpty()) {
            int cur = stack.pop();
            int left = -1;
            if(!stack.isEmpty()) {
                left = stack.peek();
            }
            max = Math.max((n-left-1)*heights[cur],max);
        }

        return max;
    }
}