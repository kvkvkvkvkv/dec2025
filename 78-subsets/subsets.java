class Solution {
    List<List<Integer>> ans = new LinkedList();
    public List<List<Integer>> subsets(int[] nums) {
        subsets(nums, 0, new LinkedList());
        return ans;
    }

    public void subsets(int[] nums, int index, LinkedList<Integer> temp) {
        if(index == nums.length) {
            ans.add(new ArrayList(temp));
            return;
        }

        subsets(nums, index+1, temp);
        temp.add(nums[index]);
        subsets(nums, index+1, temp);
        temp.removeLast();
    }
}