class Solution {
    List<List<Integer>> ans = new ArrayList();
    public List<List<Integer>> permute(int[] nums) {
        permute(nums, 0);
        return ans;
    }

    public void permute(int[] nums, int index) {
        if(index == nums.length) {
            List<Integer> temp = Arrays.stream(nums).boxed().collect(Collectors.toList());
            ans.add(temp);
            return;
        }

        for(int i=index;i<nums.length;i++) {
            swap(i,index, nums);
            permute(nums, index+1);
            swap(i,index, nums);
        }
    }

    void swap(int i, int j, int[]nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}