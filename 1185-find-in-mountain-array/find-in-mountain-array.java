/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int pivot = pivot(mountainArr);

        int bin1 = bin(mountainArr, target, 0, pivot);
        int bin2 = bin1(mountainArr, target, pivot+1, mountainArr.length()-1);
        return bin1!=-1?bin1:bin2;
    }

    public int bin(MountainArray mountainArray, int target, int l, int r) {

        while(l<=r) {
            int mid = l+(r-l)/2;

            if(mountainArray.get(mid) == target) {
                return mid;
            }
            if(mountainArray.get(mid)>target) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        return -1;
    }

    public int bin1(MountainArray mountainArray, int target, int l, int r) {

        while(l<=r) {
            int mid = l+(r-l)/2;
            int cur = mountainArray.get(mid);
            if(cur == target) {
                return mid;
            }
            if(cur<target) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        return -1;
    }

    public int pivot(MountainArray mountainArr) {
        int l = 1;
        int r = mountainArr.length()-2;

        while (l<=r) {
            int mid = l+(r-l)/2;
            int cur = mountainArr.get(mid);
            int prev = mountainArr.get(mid-1);
            int next = mountainArr.get(mid+1);
            if(cur>prev && cur>next) {
                return mid;
            }

            if(cur>prev) {
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        return -1;
    }
}