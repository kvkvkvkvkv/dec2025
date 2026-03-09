class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for(String ele:operations) {
            if(ele.equals("+")) {
                int top = stack.pop();
                int top2 = stack.pop();
                int add = top + top2;
                stack.push(top2);
                stack.push(top);
                stack.push(add);
            } else if(ele.equals("D")) {
                int top = stack.pop();
                int twice = top*2;
                stack.push(top);
                stack.push(twice);
            } else if(ele.equals("C")){
                stack.pop();
            } else {
                int value = Integer.valueOf(ele);
                stack.push(value);
            }
        }
        int sum = 0;
        while(!stack.isEmpty()) {
            sum+=stack.pop();
        }
        return sum;
    }
}