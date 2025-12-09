class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n-1;

        int lMax = left;
        int rMax = right;
        int max = -1;
        while(left<right) {

            if(height[rMax]<height[right]) {
                rMax = right;
            }

            if(height[lMax]<height[left]) {
                lMax = left;
            }
            
            if(height[left]<=height[rMax]) {
                max = Math.max(max, Math.min(height[left], height[rMax])*(rMax-left));
                left++;
            } else {
                max = Math.max(max, Math.min(height[right], height[lMax])*(right- lMax));
                right--;
            }
        }
        return max;
    }
}