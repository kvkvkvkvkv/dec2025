class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<Integer> stack = new Stack();
        int[] ans = new int[temp.length];
        for(int i=temp.length-1;i>=0;i--) {

            if(stack.isEmpty()) {
                stack.add(i);
            } else if(temp[stack.peek()]<=temp[i]){
                while(stack.size()>0 && temp[stack.peek()]<=temp[i]) {
                    stack.pop();
                }
                if(stack.size()>0) {
                    ans[i] = stack.peek()-i;
                }
                stack.add(i);
            } else {
                ans[i] = stack.peek()-i;
                stack.add(i);
            }
        }
        return ans;
    }
}