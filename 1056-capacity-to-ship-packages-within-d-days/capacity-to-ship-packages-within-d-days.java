class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = 0;
        int sum =0;
        for(int ele:weights) {
            max = Math.max(max, ele);
            sum+=ele;

        }

        int l = max;
        int r = sum;

        while(l<=r) {
            int mid = l+(r-l)/2;
            long hours = count(weights, mid);
            if(hours>days) {
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        return l;
    }


    long count(int[] piles, int val) {
        long sum = 0;
        long h = 0;
        for(int i=0;i<piles.length;i++) {
            sum+=piles[i];
            if(sum>val) {
                h++;
                sum = piles[i];
            }
        }
        h++;
        return h;
    }
}