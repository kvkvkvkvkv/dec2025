class Solution {
    Map<Integer, Integer> map = new HashMap<>();
        
    public int[] topKFrequent(int[] nums, int k) {
        for(int ele:nums) {
            map.put(ele, map.getOrDefault(ele, 0)+1);
        }
        int[] val = new int[map.size()];
        int in = 0;
        for(int key:map.keySet()) {
            val[in++] = key;
        }
        findK(val, k, 0, val.length-1);
        return Arrays.copyOfRange(val, val.length-k, val.length);
    }

    public void findK(int[] nums, int k, int l, int r) {
        int mid = l+(r-l)/2;
        int pivot = sort(nums, k, l, r);
        if(pivot == nums.length - k) {
            return;
        }
        if(nums.length-k>pivot) {
            findK(nums, k, pivot+1, r);
        } else {
            findK(nums, k, l, pivot-1);
        }
    }

    int sort(int[] nums, int k, int l, int r) {
        int i=l;
        int p = r;
        for(int j=l;j<r;j++) {
            if(map.get(nums[j])<=map.get(nums[p])) {
                swap(i, j, nums);
                i++;
            } 
        }
        swap(i, p, nums);
        return i;
    }

    void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}