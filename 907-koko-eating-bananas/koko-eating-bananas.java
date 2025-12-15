class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        long l =1;
        long r = 0;
        long n = piles.length;
        for(int i=0;i<n;i++) {
            r = Math.max(r, piles[i]);
        }

        while(l<=r) {
            long mid = l+(r-l)/2;

            long hours = count(mid, piles);
            if(hours<=h) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        return (int)l;
    }

    long count(long mid, int[] piles) {
        long hour = 0;

        for(int ele:piles) {
            if(ele%mid!=0) {
                hour++;
            }
            hour += (ele/mid);
        }
        return hour;
    }
}