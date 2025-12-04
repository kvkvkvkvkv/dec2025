class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> values = new HashSet();
        for(int ele:nums) {
            values.add(ele);
        }

        //O(n+n) is the complexity here
        int count = 0;
        int max = 0;
        for(int ele:values) {
            int start = ele;
            if(!values.contains(start-1)) {
                while(values.contains(start)) {
                    start++;
                }
            }
            max = Math.max(start-ele, max);
        }
        return max;
    }
}