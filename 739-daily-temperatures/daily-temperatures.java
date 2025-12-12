class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<Integer> stack = new Stack();
        int[] ans = new int[temp.length];
        for(int index = 0;index<temp.length;index++) {

            if(stack.isEmpty()) {
                stack.push(index);
            } else {
                while(!stack.isEmpty() && temp[stack.peek()]<temp[index]) {
                    int cur = stack.pop();
                    ans[cur] = index-cur; 
                }
                stack.push(index);
            }
        }

        return ans;
    }
}