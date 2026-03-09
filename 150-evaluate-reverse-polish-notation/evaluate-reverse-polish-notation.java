class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String ele:tokens) {

            switch (ele) {
                case "+":
                    int v1 = Integer.valueOf(stack.pop());
                    int v2 = Integer.valueOf(stack.pop());
                    stack.push(v1+v2);
                    break;
                case "-":
                    int v3 = Integer.valueOf(stack.pop());
                    int v4 = Integer.valueOf(stack.pop());
                    stack.push(v4-v3);
                    break;
                case "/":
                    int v5 = Integer.valueOf(stack.pop());
                    int v6 = Integer.valueOf(stack.pop());
                    stack.push(v6/v5);
                    break;
                case "*":
                    int v7 = Integer.valueOf(stack.pop());
                    int v8 = Integer.valueOf(stack.pop());
                    stack.push(v8 *v7);
                    break;    
                default:
                    int v9 = Integer.valueOf(ele);
                    stack.push(v9);
                    break;
            }
        }

        return stack.pop();
    }
}