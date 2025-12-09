class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = height[0];
        right[n-1] = height[n-1];

        for(int index=1;index<n;index++) {
            left[index] = Math.max(left[index-1],height[index]);
        }

        for(int index=n-2;index>=0;index--) {
            right[index] = Math.max(right[index+1],height[index]);
        }

        int sum = 0;
        for(int index=0;index<n;index++) {
            sum += Math.min(left[index],right[index])-height[index];
        }
        return sum;
    }
}