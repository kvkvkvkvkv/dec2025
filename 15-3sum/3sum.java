class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList();
        for(int i=0;i<=nums.length-3;i++) {
            int left = i+1;
            int right = nums.length-1;
            if(left<right) {
                twoSum(nums, i, left, right, ans);
            }
            while(i<nums.length-3 && nums[i+1]==nums[i]) {
                i++;
            }
        }

        return ans;
    }

    public void twoSum(int[] numbers, int up, int left, int right, List<List<Integer>> ans) {
        while(left<right) {
            int sum = numbers[up] + numbers[left] + numbers[right];
            List<Integer> temp = new ArrayList();
            if(sum == 0) {
                temp.add(numbers[up]);
                temp.add(numbers[left]);
                temp.add(numbers[right]);
                ans.add(temp);
            }

            if(sum>0) {
                right--;
                while(left<right && numbers[right]==numbers[right+1]) {
                    right--;
                }
            } else {
                left++;
                while(left<right && numbers[left]==numbers[left-1]) {
                    left++;
                }
            }
        }
    }
}