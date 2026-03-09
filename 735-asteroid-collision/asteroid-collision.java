class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int ele:asteroids) {
            
            if(ele>0) {
                stack.push(ele);
                continue;
            } 

            if(ele<0 && stack.isEmpty()) {
                stack.push(ele);
                continue;
            }

            while(!stack.isEmpty() && stack.peek()>0 && -ele>stack.peek()) {
                stack.pop();
            }

            if(!stack.isEmpty() && ele == -stack.peek()) {
                stack.pop();
                continue;
            }

            if(stack.isEmpty() || -ele > stack.peek()) {
                stack.push(ele);
                continue;
            }
            
        }
        int[] ans = new int[stack.size()];
        int idx = stack.size()-1;

        while (!stack.isEmpty()) {
            ans[idx--] = stack.pop();
        }

        return ans;
    }
}