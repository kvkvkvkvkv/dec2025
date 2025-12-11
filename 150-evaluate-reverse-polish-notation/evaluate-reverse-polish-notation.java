class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> stack = new Stack();

        for(String ele:tokens) {
            if(isNum(ele)){
                stack.add(Integer.valueOf(ele));
            } else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                if(ele.equals("+")) {
                    stack.push(num1+num2);
                } else if(ele.equals("-")) {
                    stack.push(num1-num2);
                } else if(ele.equals("*")) {
                    stack.push(num1*num2);
                } else {
                    stack.push(num1/num2);
                }
            }
        }
        return stack.pop();
    }

    boolean isNum(String ele) {
        return !ele.equals("-") && !(ele.equals("+")) && !(ele.equals("*")) && !(ele.equals("/"));
    }
}