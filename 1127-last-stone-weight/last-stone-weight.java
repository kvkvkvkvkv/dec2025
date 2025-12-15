class Solution {
    public int lastStoneWeight(int[] stones) {
        int max = 0;
        for(int ele:stones) {
            max = Math.max(max, ele);
        }
        int[] stone = new int[max+1];

        for(int ele:stones) {
            stone[ele]++;
        }
        
        int big = 0;
        int cur = max;

        while(cur>0) {
            if(stone[cur]==0) {
                cur--;
            } else if(big == 0) {
                stone[cur]%=2;
                if(stone[cur] == 1) {
                    big = cur;
                }
                cur--;
            } else {
                stone[cur]--;
                if(big-cur<=cur) {
                    stone[big-cur]++;
                    big = 0;
                } else {
                    big-=cur;
                }
            }
        }
        return big;
    }
}