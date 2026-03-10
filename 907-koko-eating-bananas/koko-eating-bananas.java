class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int r = 0;
        for(int ele:piles) {
            r = Math.max(r, ele);

        }

        int l = 1;
        

        while(l<=r) {
            int mid = l+(r-l)/2;

            long hours = count(piles, mid);

            if(hours>h) {
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        return l;
    }

    long count(int[] piles, int val) {
        long h = 0;
        for(int i=0;i<piles.length;i++) {
            int count = piles[i];
            h+=((long)count/val);
            if(count%val != 0) {
                h++;
            }
        }
        return h;
    }
}