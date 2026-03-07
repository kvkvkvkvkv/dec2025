class Solution {
    public int maxProfit(int[] nums) {
        int max = 0;
        int min = 0;
        int sum = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[min]>nums[i]) {
                sum = Math.max(sum,nums[max] - nums[min]);
                min = i;
                max = i;
                
            }
            max = nums[max]>=nums[i]?max:i;
            min = nums[min]<=nums[i]?min:i;
        }
        sum = Math.max(sum,nums[max] - nums[min]);
        return sum;
    }
}