class Solution {
    public int removeElement(int[] nums, int val) {
        int j = 0;
        int count = 0;
        for(int i=0;i<nums.length;i++) {
            if(j< nums.length && nums[j] != val) {
                j++;    
                continue;
            }

            if(nums[i] == val) {
                continue;
            }

            if(i<j) {
                count++;
            }

            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
            count++;
            j++;
        
        }
        
        for(int index=nums.length-1;index>=0;index--) {
            if(nums[index] == val) {
                continue;
            } else {
                return index+1;
            }
        }
        return 0;
    }
}