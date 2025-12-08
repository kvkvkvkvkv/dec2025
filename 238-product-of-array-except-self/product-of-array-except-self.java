class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prev = new int[nums.length];
        prev[0] = 1;
        
        for(int index=1;index<nums.length;index++) {
            prev[index]= prev[index-1]*nums[index-1];
        }

        int temp = 1;
        for(int index=nums.length-2;index>=0;index--) {
            temp = temp*nums[index+1];
            prev[index] = prev[index] * temp;
        }

        // for(int index=0;index<nums.length;index++) {
        //     prev[index]= prev[index]*next[index];
        // }
        return prev;
    }
}