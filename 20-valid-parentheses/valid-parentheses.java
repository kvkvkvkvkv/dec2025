class Solution {
    //number will only work if given it'll be valid
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack();
        for(char ele:s.toCharArray()) {

            if(stack.isEmpty() && isClose(ele)){
                return false;
            }

            if(ele == ')') {
                if(stack.peek()!='(') {
                    return false;
                }
                stack.pop();
            } else if(ele == ']') {
                if(stack.peek()!='[') {
                    return false;
                }
                stack.pop();
            } else if(ele == '}') {
                if(stack.peek()!='{') {
                    return false;
                }
                stack.pop();
            } else {
                stack.add(ele);
            }
        }
        return stack.isEmpty();
    }

    boolean isClose(char ele) {
        return ele==')' || ele==']' || ele == '}';
    }
}