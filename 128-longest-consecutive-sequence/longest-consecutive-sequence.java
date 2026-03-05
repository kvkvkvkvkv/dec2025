class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int ele:nums) {
            set.add(ele);
        }
        int max = 0;
        for(int ele:set) {
            if(set.contains(ele-1)) {
                continue;
            }

            int start = ele;

            while(set.contains(start)) {
                start++;
            }

            max = Math.max(start-ele, max);
        }

        return max;
    }
}