class Solution {
    public int trap(int[] height) {
        int ml = Integer.MIN_VALUE;
        int mr = Integer.MIN_VALUE;
        int l = 0;
        int r = height.length-1;
        int sum = 0;

        while(l<=r) {
            ml = Math.max(height[l], ml);
            mr = Math.max(height[r], mr);
            
            if(height[r]<=height[l]) {
                sum+= Math.min(ml,mr) - height[r];
                r--;
            } else {
                sum+= Math.min(ml,mr) - height[l];
                l++;
            }
        }    
        return sum;
    }
}