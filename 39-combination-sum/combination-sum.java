class Solution {
    List<List<Integer>> ans = new ArrayList();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        sum(candidates, target, 0, new LinkedList());
        return ans;
    }

    public void sum(int[] candidates, int target, int index, LinkedList<Integer> temp) {
        if(target==0) {
            ans.add(new ArrayList(temp));
            return;
        }
        if(target<0 || index == candidates.length) {
            return;
        }
        sum(candidates, target, index+1, temp);
        temp.add(candidates[index]);
        sum(candidates, target-candidates[index], index, temp);
        temp.removeLast();
    }
}