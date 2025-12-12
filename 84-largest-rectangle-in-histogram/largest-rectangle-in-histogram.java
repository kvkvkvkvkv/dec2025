class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int ans = 0;

        Stack<Integer> stack = new Stack();
        for(int index=0;index<n;index++) {
            while(!stack.isEmpty() && heights[stack.peek()]>heights[index]) {
                left[stack.pop()] = index;
            }
        
            stack.push(index);
        }

        while(!stack.isEmpty()) {
            left[stack.pop()] = n;
        }

        for(int index=n-1;index>=0;index--) {
            while(!stack.isEmpty() && heights[stack.peek()]>heights[index]) {
                right[stack.pop()] = index;
            }
            stack.push(index);
        }

        while(!stack.isEmpty()) {
            right[stack.pop()] = -1;
        }

        for(int index=0;index<n;index++) {
            ans = Math.max(ans,(left[index]-right[index]-1) * heights[index]);
        }

        return ans;
    }
}