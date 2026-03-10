class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        for(int i=0;i<path.length();i++) {
            char cur = path.charAt(i);

            if(cur == '/') {
                continue;
            }

            if(cur == '.') {
                int idx = i;
                while (idx<path.length() && path.charAt(idx)=='.') {
                    idx++;
                }

                if(idx-i==1) {
                    if(idx==path.length() || path.charAt(idx)=='/'){
                        continue;
                    } else {
                        while (idx<path.length() && path.charAt(idx)!='/') {
                            idx++;
                        }
                        stack.push(path.substring(i,idx));
                    }
                }else if(idx-i==2) {
                    if(idx==path.length() || path.charAt(idx)=='/'){
                        if(!stack.isEmpty()) {
                            stack.pop();
                        }
                    } else {
                        while (idx<path.length() && path.charAt(idx)!='/') {
                            idx++;
                        }
                        stack.push(path.substring(i,idx));
                    }
                } else if(idx-i>2){
                    while (idx<path.length() && path.charAt(idx)!='/') {
                        idx++;
                    }
                    stack.push(path.substring(i,idx));
                }
                i = idx-1;
            } else {
                int idx = i;
                while(idx<path.length() && path.charAt(idx) != '/') {
                    idx++;
                }
                stack.push(path.substring(i,idx));
                i = idx-1;
            }
        }

        LinkedList<String> list = new LinkedList<>();
        // Pop elements from the stack (LIFO order: 'c', 'b', 'a')
        while (!stack.isEmpty()) {
            list.addFirst(stack.pop());
        }
        
        StringBuffer sb = new StringBuffer();
        sb.append("/");
        for(int i=0;i<list.size();i++) {
            String ele = list.get(i);
            sb.append(ele);
            if(i<list.size()-1) {
                sb.append("/");
            }
        }

        return sb.toString();
    }
}