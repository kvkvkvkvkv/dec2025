class Solution {
    Map<String, String> parent = new HashMap();
    Map<String, Integer> rank = new HashMap();
    Map<String, List<String>> component = new HashMap();
    Map<String, String> emailParent = new HashMap();
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        init(accounts);

        for(List<String> ele:accounts) {
            for(int i=2;i<ele.size();i++) {
                union(ele.get(1), ele.get(i));
            }
        }

        for(String key:parent.keySet()) {
            String comp = find(key);
            component.computeIfAbsent(comp, v -> new ArrayList()).add(key);
        }

        List<List<String>> res = new ArrayList();
        for(String key:component.keySet()) {
            Collections.sort(component.get(key));
            String emailP = emailParent.get(key);
            List<String> temp = new ArrayList();
            temp.add(emailP);
            temp.addAll(component.get(key));
            res.add(temp);
        }
        return res;
    }

    void init(List<List<String>> accounts) {
        
        for(List<String> ele:accounts) {
            for(int i=1;i<ele.size();i++) {
                String val = ele.get(i);
                parent.put(val,val);
                rank.put(val,1);    
                emailParent.put(val,ele.get(0));
            }
        }
    }

    String find(String ele) {
        if(parent.get(ele).equals(ele)) {
            return ele;
        }
        String next = find(parent.get(ele));
        parent.put(ele, next);
        return next;
    }

    void union(String x, String y) {
        String rX = find(x);
        String rY = find(y);

        if(rX.equals(rY)) {
            return;
        }

        if(rank.get(rX)>rank.get(rY)) {
            parent.put(rY,rX);
        } else if(rank.get(rX)<rank.get(rY)) {
            parent.put(rX,rY);
        } else {
            rank.put(rY,rank.get(rX)+1);
            parent.put(rY,rX);
        }
    }
}