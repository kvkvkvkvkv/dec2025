class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int l = 0;
        int r = n-1;
        int lMax = height[0];
        int rMax = height[n-1];

        int sum = 0;
        
        while(l<r) {
            if(lMax<height[l]) {
                lMax = height[l];
            }

            if(rMax<height[r]) {
                rMax = height[r];
            }

            if(height[l]<=rMax) {
                sum += Math.min(rMax,lMax)-height[l];
                l++;
            } else {
                sum += Math.min(rMax,lMax)-height[r];
                r--;
            }
        }

        return sum;
    }
}