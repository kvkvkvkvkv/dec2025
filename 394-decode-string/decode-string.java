class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        int i=0;

        while(i<s.length()) {
            char ele = s.charAt(i);

            if(isNum(ele)) {
                int j = i;
                while(j<s.length() && isNum(s.charAt(j))) {
                    j++;
                }
                String val = s.substring(i,j);
                stack.push(val);
                i = j;
            } else if(isAlpha(ele)) {
                int j = i;
                while(j<s.length() && isAlpha(s.charAt(j))) {
                    j++;
                }
                String val = s.substring(i,j);
                stack.push(val);
                i = j;
            }else if(ele == '[') {
                stack.push(String.valueOf(ele));
                i++;
            } else {
                StringBuffer top = new StringBuffer();
                while(!stack.isEmpty() && !stack.peek().equals("[")) {
                    top.insert(0,stack.pop());
                }
                stack.pop();
                int num = 1;
                if(!stack.isEmpty()) {
                    num = Integer.valueOf(stack.pop());
                }
                StringBuilder sb = new StringBuilder();
                for(int k=0;k<num;k++) {
                    sb.append(top);
                }
                stack.push(sb.toString());
                i++;
            }
        }

        StringBuffer sb = new StringBuffer();
        for(String ele:stack) {
            sb.append(ele);
        }

        return sb.toString();
    }

    boolean isNum(char ele) {
        return ele>='0' && ele<='9';
    }

    boolean isAlpha(char ele) {
        return ele>='a' && ele<='z';
    }
}