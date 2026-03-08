class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int pivot = bin(arr, x);
        LinkedList<Integer> ans = new LinkedList();
        int l = pivot-1;
        int r = pivot;
        while(ans.size()<k) {
            int v1 = l>=0?arr[l]:(int)1e9;
            int v2 = r<arr.length?arr[r]:(int)1e9;

            if(Math.abs(v1-x)<=Math.abs(v2-x)) {
                l--;
                ans.addFirst(v1);
            } else {
                r++;
                ans.addLast(v2);
            }
        }   

        return ans;     
    }

    int bin(int[] arr, int x) {
        int l = 0;
        int r = arr.length-1;
        while(l<r) {
            int mid = l + (r-l)/2;

            if(arr[mid] == x) {
                return mid;
            }

            if(arr[mid]<x) {
                
                l = mid+1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}