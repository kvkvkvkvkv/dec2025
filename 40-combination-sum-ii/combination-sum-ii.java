class Solution {
    List<List<Integer>> ans = new ArrayList();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        sum(candidates, target, new LinkedList(), 0);
        return ans;

    }

    public void sum(int[] candidates, int target, LinkedList<Integer> temp, int index) {
        if(target<0) {
            return;
        }

        if(target == 0) {
            ans.add(new ArrayList(temp));
            return;
        }

        if(index == candidates.length) {
            return;
        }

        for(int i=index;i<candidates.length;i++) {
            if(i>index && candidates[i]==candidates[i-1]) {
                continue;
            }
            if(target-candidates[i]>=0) {
                temp.add(candidates[i]);
                sum(candidates, target-candidates[i], temp, i+1);
                temp.removeLast();
            }
        }
    }
}