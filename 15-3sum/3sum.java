class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++) {
            if(i>0 && nums[i] == nums[i-1]) {
                continue;
            }
            twoSum(nums, i, nums.length-1);
        }    

        return ans;
    }

    void twoSum(int[] nums, int i, int r) {
        int l = i+1;
        while(l<r) {
            int sum = nums[i] + nums[l] + nums[r];
            if(sum == 0) {
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[i]);
                temp.add(nums[l]);
                temp.add(nums[r]);
                ans.add(temp);
            }
            if(sum<=0) {
                l++;
                while(l<r && nums[l] == nums[l-1]) {
                    l++;
                }
            } else {
                r--;
                while(l<r && nums[r] == nums[r+1]) {
                    r--;

                }
            }
        }
    }
}