class Solution {
    List<List<Integer>> ans = new ArrayList();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        subset(nums, 0, new LinkedList());
        return ans;
    }

    public void subset(int[] nums, int index, LinkedList<Integer> temp) {
        
        if(index == nums.length) {
            ans.add(new ArrayList(temp));
            return;
        }

        temp.add(nums[index]);
        subset(nums, index+1, temp);
        temp.removeLast();

        int next = index;
        while(next<nums.length && nums[next]==nums[index]) {
            next++;
        }   
        subset(nums, next, temp);
    }
}