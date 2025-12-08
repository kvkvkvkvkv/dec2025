class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prev = new int[nums.length];
        int[] next = new int[nums.length];
        prev[0] = 1;
        next[nums.length-1] = 1;
        for(int index=1;index<nums.length;index++) {
            prev[index]= prev[index-1]*nums[index-1];
        }

        int temp = 1;
        for(int index=nums.length-2;index>=0;index--) {
            next[index]= next[index+1]*nums[index+1];
            temp = temp*nums[index+1];
            prev[index] = prev[index] * temp;
        }

        // for(int index=0;index<nums.length;index++) {
        //     prev[index]= prev[index]*next[index];
        // }
        return prev;
    }
}