class Solution {
    List<String> ans = new ArrayList();
    public List<String> generateParenthesis(int n) {
        generate(n,n,new LinkedList());
        return ans;
    }

    void generate(int open, int close, LinkedList<Character> temp) {
        if(open==0 && close==0) {
            String cur = temp.stream().map(String::valueOf).collect(Collectors.joining());
            ans.add(cur);
            return;
        }
        if(close>open) {
            temp.add(')');
            generate(open,close-1,temp);
            temp.removeLast();
        }
        if(open!=0) {
            temp.add('(');
            generate(open-1,close,temp);
            temp.removeLast();
        }
    }
}