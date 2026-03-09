class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int[] ans = new int[temp.length];
        int max = -1;
        for(int i=temp.length-1;i>=0;i--) {

            if(max<=temp[i]) {
                max = temp[i];
                continue;
            }

            int next = 1;
            while(temp[i+next]<=temp[i]) {
                next = next + ans[i+next];
            }
            ans[i] = next;
            
        }
        return ans;
    }
}