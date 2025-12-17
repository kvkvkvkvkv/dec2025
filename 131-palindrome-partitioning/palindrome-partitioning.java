class Solution {
    List<List<String>> ans = new ArrayList();
    public List<List<String>> partition(String s) {
        palin(s, 0, new LinkedList());
        return ans;
    }

    public void palin(String s, int index, LinkedList<String> temp) {
        if(index == s.length()) {
            ans.add(new ArrayList(temp));
            return;
        }

        for(int i=index;i<s.length();i++) {
            if(isPalin(index,i,s)) {
                temp.add(s.substring(index,i+1));
                palin(s,i+1,temp);
                temp.removeLast();
            }
        }
    }

    boolean isPalin(int l, int r,String s) {
        while(l<r) {
            if(s.charAt(l)!=s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}