class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int[] ans = new int[temp.length];
        int max = -1;
        for(int index=temp.length-1;index>=0;index--) {
            if(temp[index]>=max) {
                ans[index] = 0;
                max = temp[index];
            } else {
                int next = 1;
                while(index+next<temp.length && temp[index+next]<=temp[index]) {
                    next += ans[index+next];
                }
                ans[index] = next;
            }
        }
        return ans;
    }
}